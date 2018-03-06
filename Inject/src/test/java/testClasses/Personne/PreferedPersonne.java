package testClasses.Personne;

import annotations.Prefered;

@Prefered
public class PreferedPersonne implements IPersonne {

  @Override public String showClassIdentifier() {
    return "PreferedPerson";
  }
}
