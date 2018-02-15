package testClasses.Organe;

import annotations.Inject;

public class Cerveau implements IOrgane{

    @Inject
    private Veine veine;

    public Veine getVeine() {
        return veine;
    }
}
