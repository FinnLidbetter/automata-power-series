import java.util.Set;
import java.util.Map;
public abstract class Automaton {
  Set<State> stateSpace;
  Set<Character> inputAlphabet;
  Map<TransitionInput, TransitionOutput> delta;
  Configuration initial;
  public Automaton(Set<State> stateSpace, Set<Character> inputAlphabet, Map<TransitionInput,TransitionOutput> delta, Configuration initial) {
    this.stateSpace = stateSpace;
    this.inputAlphabet = inputAlphabet;
    this.delta = delta;
    this.initial = initial;
  }

  public Configuration read(String input) {
    Configuration currentConfiguration = initial;
    for (Character currentCharacter : input.toCharArray()) {
      TransitionInput deltaArgument = new TransitionInput(currentConfiguration.getDesiderata(), currentCharacter);
      if (delta.containsKey(deltaArgument)) {
        TransitionOutput result = delta.get(deltaArgument);
        currentConfiguration = currentConfiguration.update(result);
      } else {
        return null;
      }
    }
    return currentConfiguration;
  }
}
