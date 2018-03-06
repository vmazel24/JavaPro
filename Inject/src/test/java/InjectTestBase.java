import annotations.Inject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import testClasses.Personne.PreferedPersonne;
import testClasses.Personne.IPersonne;
import testClasses.Personne.UnpreferedPerson;

import static junit.framework.TestCase.assertNull;



public class InjectTestBase {

    @Inject
    private IPersonne personneInterface;

    private PreferedPersonne personneNotInjected;



    @Before
    public void setUp() throws Exception{
        Injector.inject(this);
    }



    @Test
    public void testWithoutInject(){
        assertNull(personneNotInjected);
    }

    @Test
    public void testNotNull(){
        Assert.assertNotNull(personneInterface);
    }

    @Test
    public void testRightPreferedFromInterface(){
        Assert.assertEquals("PreferedPerson", personneInterface.showClassIdentifier());
    }





}
