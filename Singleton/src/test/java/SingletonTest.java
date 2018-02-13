import annotations.Inject;
import impl.Personne;
import impl.PersonneNotSingleton;
import impl.PersonneSingleton;
import interfaces.IPersonne;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SingletonTest {

    @Inject
    private PersonneNotSingleton personneNotSingleton;

    @Inject
    private PersonneSingleton personneSingleton;

    @BeforeEach
    public void setUp() throws Exception{
        personneSingleton = new PersonneSingleton();
        personneSingleton.setNom("Bob");

        personneNotSingleton = new PersonneNotSingleton();
        personneNotSingleton.setNom("Bob");
    }

    @Test
    void testExpectedComportementWithoutSingleton(){
        Personne pTest = new Personne();
        assertNotEquals(personneNotSingleton.getNom(), pTest.getNom());
    }

    @Test
    void testExpectedComportementWithSingleton(){
        PersonneSingleton pTest = new PersonneSingleton();
        assertEquals(personneSingleton.getNom(), pTest.getNom());
    }


}

