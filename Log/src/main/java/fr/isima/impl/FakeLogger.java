package fr.isima.impl;

import fr.isima.api.annotations.Prefered;
import fr.isima.api.annotations.Singleton;
import fr.isima.interfaces.ILogger;

@Prefered
@Singleton
public class FakeLogger implements ILogger {

    public int numberOfLog = 0;

    @Override public void incrementLog() {
        numberOfLog++;
    }

    @Override public int getLoggerNumber() {
        return numberOfLog;
    }
}
