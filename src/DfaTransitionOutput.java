public class DfaTransitionOutput implements TransitionOutput {
  State nextState;
  public DfaTransitionOutput(State state) {
    nextState = state;
  }
  public State getState() {
    return nextState;
  }
}
