package impl;

import interfaces.IPersonne;
import java.util.Date;

public class PersonneNotSingleton implements IPersonne {
    @Override public Date getCreationTime() {
        return new Date();
    }
}
