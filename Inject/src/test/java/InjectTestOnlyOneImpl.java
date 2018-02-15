import annotations.Inject;
import impl.Injector;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import testClasses.Organe.Cerveau;
import testClasses.Organe.IOrgane;

public class InjectTestOnlyOneImpl {

    @Inject
    IOrgane organe;

    @Before
    public void setUp() throws Exception{
        Injector.doInjections(this);
    }

    @Test
    public void testInjectInInterfaceWithoutPrefered(){
        Assert.assertEquals(organe.getClass(), Cerveau.class);
    }
}
