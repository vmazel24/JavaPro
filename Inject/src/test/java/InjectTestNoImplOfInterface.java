import fr.isima.api.annotations.Inject;
import fr.isima.api.exceptions.NoImplementationOfInterface;
import org.junit.Test;
import testClasses.Vehicule.IVehicule;

public class InjectTestNoImplOfInterface {

    @Inject
    private IVehicule vehicule;

    @Test(expected= NoImplementationOfInterface.class)
    public void testInjectInterfaceWoImpl() throws Exception{
        //TODO
    }
}
