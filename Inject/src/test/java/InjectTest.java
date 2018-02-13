import annotations.Inject;
import impl.Injector;
import impl.Personne;
import interfaces.IPersonne;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class InjectTest {

    @Inject
    private IPersonne personne;
    @Inject
    private Personne personneReel;

    private Personne personneNotInjected;

    @BeforeEach
    public void setUp() throws Exception{
        Injector.inject(this.getClass());
    }


    //Cas une interface sans implementation

    @Test
    public void testWithoutInject(){
        assertNull(personneNotInjected);
    }

    @Test
    public void testNotNull(){
        assertNotNull(personne);
    }

    @Test
    public void testGoodClass(){
        assertEquals(IPersonne.class, personne.getClass());
    }

    @Test
    public void testInjectInterfaceWithoutPrefered(){
        //assertThrows()
        // Should throw an exception.
    }

//    @BeforeEach
//    void setUpBeforeEach() throws Exception{
//        inject = new Injector();
//    }
//
//    @Test
//    void firstInjectTest() throws InstantiationException, IllegalAccessException{
//        assertNotNull(inject.inject(Personne.class));
//    }
//
//    @Test
//    void correspondingClassInjectTest() throws InstantiationException, IllegalAccessException{
//        assertEquals(Personne.class, inject.inject(Personne.class).getClass());
//    }
}
