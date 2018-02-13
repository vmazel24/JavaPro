import annotations.Inject;
import impl.FakeLogger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LogTest {

    @Inject
    private FakeLogger fakeLogger;

    @BeforeEach
    public void setUp(){
        fakeLogger.reset();
    }

    @Test
    public void testLogged(){
        fakeLogger.execute();
        assertTrue(fakeLogger.getBefore());
        assertTrue(fakeLogger.getAfter());
    }
}
