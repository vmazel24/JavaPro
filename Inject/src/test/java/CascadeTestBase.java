import fr.isima.api.annotations.Inject;
import fr.isima.api.Injector;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import testClasses.Organe.IOrgane;

public class CascadeTestBase {

    @Inject
    private IOrgane organe;

    @Before
    public void setUp() throws Exception{
        Injector.inject(this);
    }

    @Test
    public void testWithoutInject(){
        Assert.assertNotNull(organe.getVaisseau());
    }

    @Test
    public void testValidClasses()
    {
        Assert.assertEquals("Cerveau", organe.showClassIdentifier());
        Assert.assertEquals("Veine", organe.getVaisseau().showClassIdentifier());
    }

}
