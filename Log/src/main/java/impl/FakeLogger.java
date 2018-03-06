package impl;

import fr.isima.api.annotations.Prefered;
import fr.isima.api.annotations.Singleton;
import interfaces.ILogger;

@Prefered
@Singleton
public class FakeLogger implements ILogger {

    public int numberOfLog = 0;

    @Override public int getLogNumber() {
        numberOfLog++;
        return numberOfLog;
    }
}
