package impl;

import annotations.Prefered;
import annotations.Singleton;

@Prefered
@Singleton
public class FakeLogger {
    private boolean before;
    private boolean after;

    public FakeLogger(){
        before = false;
        after = false;
    }

    public void execute(){
        before();
        after();
    }

    private void before(){
        before = true;
    }

    private void after(){
        after = true;
    }

    public void reset(){
        before = false;
        after = false;
    }

    public boolean getBefore(){
        return before;
    }

    public boolean getAfter(){
        return after;
    }

}
