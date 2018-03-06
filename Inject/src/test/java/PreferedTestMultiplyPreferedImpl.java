import annotations.Inject;
import exceptions.MultiplyPreferedClasses;
import org.junit.Assert;
import org.junit.Test;
import testClasses.Maison.IMaison;
import testClasses.Vehicule.IVehicule;

public class PreferedTestMultiplyPreferedImpl {

    @Inject
    private IMaison maison;

    @Test(expected= MultiplyPreferedClasses.class)
    public void testMultiplyPreferedInterface() throws Exception{
        //TODO
    }
}
