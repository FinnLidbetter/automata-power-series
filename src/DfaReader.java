import java.io.*;
import java.util.Set;
import java.util.Map;
import java.util.HashSet;
import java.util.HashMap;
import java.util.regex.Pattern;

public class DfaReader {
  static final String GRAIL_START_STRING = "\\(START\\)";
  static final String GRAIL_FINAL_STRING = "\\(FINAL\\)";
  static final String NONNEGATIVE_INT = "(0|([1-9][0-9]*))";
  static final String GRAIL_INITIAL_STATE_REGEX = GRAIL_START_STRING+" \\|- "+NONNEGATIVE_INT;
  static final String GRAIL_FINAL_STATE_REGEX = NONNEGATIVE_INT+" -\\| "+GRAIL_FINAL_STRING;
  static final String GRAIL_TRANSITION_REGEX = NONNEGATIVE_INT+" \\p{Print} "+NONNEGATIVE_INT;

  BufferedReader br;
  public DfaReader(InputStream in) {
    br = new BufferedReader(new InputStreamReader(in));
  }
  public DfaReader(String fileName) {
    InputStream inputStream = null;
    try {
      inputStream = new FileInputStream(fileName);
      inputStream.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    br = new BufferedReader(new InputStreamReader(inputStream));
  }

  public Dfa buildDfaFromGrail() throws IOException {
    Set<State> stateSpace = new HashSet<State>();
    Set<Character> alphabet = new HashSet<Character>();
    Map<TransitionInput,TransitionOutput> delta = new HashMap<TransitionInput, TransitionOutput>();
    DfaConfiguration initialState = null;
    Set<State> acceptingStates = new HashSet<State>();
    
    String line = br.readLine();
    while (line!=null) {
      if (Pattern.matches(GRAIL_INITIAL_STATE_REGEX, line)) {
        if (initialState==null) {
          String[] tokens = line.split(" ");
          State startState = new State(Integer.parseInt(tokens[2]));
          stateSpace.add(startState);
          initialState = new DfaConfiguration(startState);
        } else {
          System.err.println("Error: multiple initial states given");
          return null;
        }
      } else if (Pattern.matches(GRAIL_FINAL_STATE_REGEX, line)) {
        String[] tokens = line.split(" ");
        State finalState = new State(Integer.parseInt(tokens[0]));
        stateSpace.add(finalState);
        acceptingStates.add(finalState);
      } else if (Pattern.matches(GRAIL_TRANSITION_REGEX, line)) {
        String[] tokens = line.split(" ");
        State from = new State(Integer.parseInt(tokens[0]));
        Character symbol = new Character(tokens[1].charAt(0));
        State to = new State(Integer.parseInt(tokens[2]));
        stateSpace.add(from);
        alphabet.add(symbol);
        stateSpace.add(to);
        TransitionInput currentTransitionInput = new TransitionInput(new DfaConfigurationDesiderata(from), symbol);
        DfaTransitionOutput currentTransitionOutput = new DfaTransitionOutput(to);
        delta.put(currentTransitionInput, currentTransitionOutput);
      } else {
        System.err.println("Error: invlaid Grail input. The following unexpected line was read:");
        System.err.println(line);
        return null;
      }

      line = br.readLine();
    }
    return new Dfa(stateSpace, alphabet, delta, initialState, acceptingStates);
  }
}
