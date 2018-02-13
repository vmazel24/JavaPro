import annotations.Inject;
import impl.Injector;
import testClasses.IMaison;
import testClasses.PreferedPersonne;
import testClasses.IPersonne;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class InjectTest {

    @Inject
    private IPersonne personneInterface;

    @Inject
    private PreferedPersonne personneClasse;

    private PreferedPersonne personneNotInjected;

    @Inject
    private IMaison maison;

    @BeforeEach
    public void setUp() throws Exception{
        Injector.doInjections(this);
    }


    //Cas une interface sans implementation

    @Test
    public void testWithoutInject(){
        assertNull(personneNotInjected);
    }

    @Test
    public void testNotNull(){
        assertNotNull(personneInterface);
    }

    @Test
public void testRightClass(){ //--> A debug, ca devrait passer la
        assertEquals(PreferedPersonne.class, personneClasse.getClass());
    }

    @Test
    public void testRightPreferedFromInterface(){
        assertEquals(personneInterface.getClass(), PreferedPersonne.class);
    }

//    @Test
//    public void testMultiplyPreferedInterface(){
//        //assertEquals(IMaison.getClass(), IMaison.class);
//        //Necessite de faire plusieurs classes d etests : plus propre
//    }

    @Test
    public void testInjectInterfaceWithoutPrefered(){
        //cas ou on a une seule implementation sans prefered pour une interface
        //On doit retrouver cette impl
    }

}
