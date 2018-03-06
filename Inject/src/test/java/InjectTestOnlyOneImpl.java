import annotations.Inject;
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
        //TODO
    }

    @Test
    public void testInjectInInterfaceWithoutPrefered(){
        Assert.assertEquals(organe.getClass(), Cerveau.class);
    }
}
