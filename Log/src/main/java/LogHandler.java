import fr.isima.api.annotations.Inject;
import fr.isima.api.handler.ComportmentInterface;
import interfaces.ILogger;

public class LogHandler implements ComportmentInterface {

  @Inject
  private ILogger logger;

  @Override public void before() {
    logger.getLogNumber();
  }

  @Override public void after() {

  }
}
