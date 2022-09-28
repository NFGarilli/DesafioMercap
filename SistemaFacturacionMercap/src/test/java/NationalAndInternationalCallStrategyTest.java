import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class NationalAndInternationalCallStrategyTest{

        @Test
        public void aNationalAndInternationalCallStrategyCallOf5MinutesToSanLuisWhoseCostPerMinuteIs$3ItsCostIs$15(){

            Integer callDuration = 5;
            Destination sanLuis = new Destination(3.0,  "SanLuis");
            LocalDateTime callDateTime = LocalDateTime.now();

            CallDetails callDetails = new CallDetails(callDuration, sanLuis, callDateTime);
            Double expectedCost = callDuration * sanLuis.costPerMinute;

            NationalAndInternationalCallStrategy strategy = new NationalAndInternationalCallStrategy();

            Double callCost = strategy.call(callDetails);

            assertEquals(expectedCost, callCost);
        }

}
