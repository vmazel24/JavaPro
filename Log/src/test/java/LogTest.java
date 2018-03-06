import fr.isima.api.Injector;
import fr.isima.api.annotations.Inject;
import fr.isima.api.exceptions.MultiplyPreferedClasses;
import impl.FakeLogger;
import interfaces.ILogger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testclasses.IMeuble;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogTest {

    @Inject
    private IMeuble table;

    @Inject
    private ILogger fakeLogger; //Singleton

    @BeforeEach
    public void setUp()
        throws IllegalAccessException, MultiplyPreferedClasses, InstantiationException {
        Injector.inject(this);
    }

    @Test
    public void testLogged(){
        table.flip();
        table.flip();
        table.flip();
        assertEquals(3, fakeLogger.getLogNumber());
    }
}
