package testClasses.Organe;

import fr.isima.api.annotations.Prefered;

@Prefered
public class Veine implements IVaisseau{
  @Override public String showClassIdentifier() {
    return "Veine";
  }
}
