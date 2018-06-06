public class DfaConfiguration implements Configuration {
  protected State state;
  public DfaConfiguration(State state) {
    this.state = state;
  }
  
  public State getState() {
    return state;
  }

  public DfaConfigurationDesiderata getDesiderata() {
    return new DfaConfigurationDesiderata(state);
  }

  public DfaConfiguration update(TransitionOutput output) {
    DfaTransitionOutput dfaTransitionOutput = null;
    try {
      dfaTransitionOutput = (DfaTransitionOutput) output;
    } catch (ClassCastException e) {
      System.err.println("Error in reading transition output and updating DFA configuration");
      return null;
    }
    return new DfaConfiguration(dfaTransitionOutput.getState());
  }
}
