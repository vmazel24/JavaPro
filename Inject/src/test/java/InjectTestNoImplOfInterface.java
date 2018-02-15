import annotations.Inject;
import exceptions.NoImplementationOfInterface;
import impl.Injector;
import org.junit.Test;
import testClasses.Vehicule.IVehicule;

public class InjectTestNoImplOfInterface {

    @Inject
    private IVehicule vehicule;

    @Test(expected= NoImplementationOfInterface.class)
    public void testInjectInterfaceWoImpl() throws Exception{
        Injector.doInjections(this);
    }
}
