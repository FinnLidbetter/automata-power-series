public class DfaConfigurationDesiderata implements ConfigurationDesiderata {
  State state;
  public DfaConfigurationDesiderata(State state) {
    this.state = state;
  }
  
  public State getState() {
    return state;
  }
  
  @Override
  public int hashCode() {
    return state.getId();
  }

  @Override
  public boolean equals(Object o) {
    DfaConfigurationDesiderata config2 = (DfaConfigurationDesiderata) o;
    return state.equals(config2.getState());
  }
}
