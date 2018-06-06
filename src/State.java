public class State {
  protected int id;
  public State(int id) {
    this.id = id;
  }
  public int getId() {
    return id;
  }

  @Override
  public int hashCode() {
    return id;
  }

  @Override
  public boolean equals(Object o) {
    State s2 = (State) o;
    return id==s2.getId();
  }
}
