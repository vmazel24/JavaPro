package testclasses;

import fr.isima.api.annotations.Prefered;
import fr.isima.api.annotations.Singleton;
import java.util.Date;

@Singleton
@Prefered
public class PersonneSingleton implements IPersonne {

  @Override public Date getCreationTime() {
    return new Date();
  }
}
