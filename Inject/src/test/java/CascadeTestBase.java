import annotations.Inject;
import impl.Injector;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import testClasses.Organe.IOrgane;

public class CascadeTestBase {

    @Inject
    private IOrgane organe;

    @Before
    public void setUp() throws Exception{
        Injector.doInjections(this);
    }

    @Test
    public void testWithoutInject(){
        Assert.assertNotNull(organe.getVeine());
    }

}
