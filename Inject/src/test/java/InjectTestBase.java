import annotations.Inject;
import impl.Injector;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import testClasses.Personne.PreferedPersonne;
import testClasses.Personne.IPersonne;

import static junit.framework.TestCase.assertNull;



public class InjectTestBase {

    @Inject
    private IPersonne personneInterface;

    @Inject
    private PreferedPersonne personneClasse;

    private PreferedPersonne personneNotInjected;



    @Before
    public void setUp() throws Exception{
        Injector.doInjections(this);
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
    public void testRightClass(){ //--> A debug, ca devrait passer la
        Assert.assertEquals(PreferedPersonne.class, personneClasse.getClass());
    }

    @Test
    public void testRightPreferedFromInterface(){
        Assert.assertEquals(personneInterface.getClass(), PreferedPersonne.class);
    }





}
