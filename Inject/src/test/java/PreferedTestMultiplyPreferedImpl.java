import fr.isima.api.annotations.Inject;
import fr.isima.api.exceptions.MultiplyPreferedClasses;
import org.junit.Test;
import testClasses.Maison.IMaison;

public class PreferedTestMultiplyPreferedImpl {

    @Inject
    private IMaison maison;

    @Test(expected= MultiplyPreferedClasses.class)
    public void testMultiplyPreferedInterface() throws Exception{
        //TODO
    }
}
