package testClasses.Personne;

import fr.isima.api.annotations.Prefered;

@Prefered
public class PreferedPersonne implements IPersonne {

  @Override public String showClassIdentifier() {
    return "PreferedPerson";
  }
}
