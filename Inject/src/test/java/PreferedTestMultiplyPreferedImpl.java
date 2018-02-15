import annotations.Inject;
import exceptions.MultiplyPreferedClasses;
import impl.Injector;
import org.junit.Assert;
import org.junit.Test;
import testClasses.Maison.IMaison;
import testClasses.Vehicule.IVehicule;

public class PreferedTestMultiplyPreferedImpl {

    @Inject
    private IMaison maison;

    @Test(expected= MultiplyPreferedClasses.class)
    public void testMultiplyPreferedInterface() throws Exception{
        Injector.doInjections(this);
    }
}
