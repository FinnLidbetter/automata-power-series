import java.util.Objects;
public class TransitionInput {
  protected ConfigurationDesiderata configurationDesiderata;
  protected Character character;
  public TransitionInput(ConfigurationDesiderata configurationDesiderata, Character character) {
    this.configurationDesiderata = configurationDesiderata;
    this.character = character;
  }
  
  @Override
  public boolean equals(Object o) {
    TransitionInput input2 = (TransitionInput) o;
    return configurationDesiderata.equals(input2.getConfigurationDesiderata()) && character.equals(input2.getCharacter());
  }
  @Override
  public int hashCode() {
    return Objects.hash(configurationDesiderata, character);
  }

  public ConfigurationDesiderata getConfigurationDesiderata() {
    return configurationDesiderata;
  }
  public Character getCharacter() {
    return character;
  }
}
