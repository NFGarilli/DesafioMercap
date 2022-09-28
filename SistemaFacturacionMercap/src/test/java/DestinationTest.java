import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class DestinationTest {



    @Test
    public void givenADestinationWithACostOf50CentPerMinute_ItShouldReturn50CentOfCost(){

        Double expectedCostPerMinute = 0.50;

        Destination sanLuis = new Destination(expectedCostPerMinute, "San Luis");

        Double actualCostPerMinute = sanLuis.costPerMinute;

        assertEquals(expectedCostPerMinute, actualCostPerMinute);

    }
}  