import java.util.Set;
import java.util.Map;
public class DfaO extends Automaton {
  protected Set<Character> outputAlphabet;
  protected Map<State, Character> stateOutput;
  public DfaO(Set<State> stateSpace, Set<Character> inputAlphabet, Map<TransitionInput,TransitionOutput> delta, DfaConfiguration initial, Set<Character> outputAlphabet, Map<State,Character> stateOutput) {
    super(stateSpace, inputAlphabet, delta, initial);
    this.outputAlphabet = outputAlphabet;
    this.stateOutput = stateOutput;
  }

  public Character getOutput(String inputWord) {
    DfaConfiguration result = new DfaConfiguration(read(inputWord).getState());
    return stateOutput.get(result.getState());
  }
}
