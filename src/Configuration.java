public interface Configuration {
  public State getState();
  public abstract ConfigurationDesiderata getDesiderata();
  public abstract Configuration update(TransitionOutput output);
}
