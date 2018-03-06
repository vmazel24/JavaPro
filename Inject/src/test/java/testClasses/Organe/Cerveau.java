package testClasses.Organe;

import annotations.Inject;

public class Cerveau implements IOrgane{

    @Inject
    private IVaisseau vaisseau;

    public IVaisseau getVaisseau() {
        return vaisseau;
    }

    @Override public String showClassIdentifier() {
        return "Cerveau";
    }
}
