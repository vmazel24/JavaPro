import fr.isima.api.annotations.Inject;
import fr.isima.api.Injector;
import interfaces.IPersonne;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SingletonTest {

    @Inject
    private IPersonne personne1;

    @Inject
    private IPersonne personne2;

    @BeforeEach
    public void setUp() throws Exception{
        Injector.inject(this);
    }

    @Test
    void assertSamePersonnes()
    {
        assertEquals(personne1.toString(), personne2.toString());
    }


}

