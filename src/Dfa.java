import java.util.Set;
import java.util.Map;
public class Dfa extends Automaton {
  protected Set<State> acceptingStates;
  public Dfa(Set<State> stateSpace, Set<Character> alphabet, Map<TransitionInput,TransitionOutput> delta, DfaConfiguration initial, Set<State> acceptingStates) {
    super(stateSpace, alphabet, delta, initial);
    this.acceptingStates = acceptingStates;
  }

  public boolean accepts(String input) {
    DfaConfiguration result = new DfaConfiguration(read(input).getState());
    return acceptingStates.contains(result.getState());
  }
}
