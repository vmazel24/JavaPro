package testClasses.Organe;

import annotations.Prefered;

@Prefered
public class Veine implements IVaisseau{
  @Override public String showClassIdentifier() {
    return "Veine";
  }
}
