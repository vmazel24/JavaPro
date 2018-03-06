import annotations.Inject;
import exceptions.NoImplementationOfInterface;
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
