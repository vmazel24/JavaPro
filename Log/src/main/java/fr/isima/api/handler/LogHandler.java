package fr.isima.api.handler;

import fr.isima.api.annotations.Inject;
import fr.isima.interfaces.ILogger;

public class LogHandler implements ComportmentInterface {

  @Inject
  private ILogger logger;

  @Override public void before() {
    logger.incrementLog();
  }

  @Override public void after() {

  }
}
