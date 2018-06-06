import java.io.*;
import java.util.Set;
import java.util.Map;
import java.util.HashSet;
import java.util.HashMap;

public class DfaReader {
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

  public Dfa buildDfa() {
    Set<State> stateSpace = new HashSet<State>();
    Set<Character> alphabet = new HashSet<Character>();
    Map<TransitionInput,DfaTransitionOutput> delta = new HashMap<TransitionInput, DfaTransitionOutput>();
    State initialState;
    Set<State> acceptingStates = new HashSet<State>();

    return null;
  }
}
