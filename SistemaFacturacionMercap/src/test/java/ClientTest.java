import org.junit.Test;
import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;

public class ClientTest {

    @Test
    public void aClientMakesAnInternationalCallToJapanWithADurationOf1MinuteAndItsCostIsOf15() {

        Destination japan       = new Destination(15.0, "japan");
        Client client1          = new Client("Juan", 30.0);
        CallDetails callDetails = new CallDetails(1, japan, LocalDateTime.now());

        Double actualCostOfCall     = client1.makeCall(callDetails, Client.CallType.NATIONALORINTERNATIONALCALL);
        Double expectedCostOfCall   = 15.0;

        assertEquals(expectedCostOfCall, actualCostOfCall);
    }

    @Test
    public void aClientMakesALocalCallWithADurationOf1MinuteInAWeekDayOnARushHourAndItsCostIs2Cents(){
            //DEBUG ESTE CON DIA 26 ROMPE
        LocalDateTime weekDayRushHour = LocalDateTime.of(2022,9,28,12,0);
        Client client1          = new Client("Juan", 30.0);
        CallDetails callDetails = new CallDetails(1, new Destination(), weekDayRushHour);

        Double actualCostOfCall     = client1.makeCall(callDetails, Client.CallType.LOCALCALL);
        Double expectedCostOfCall   = 0.2;

        assertEquals(expectedCostOfCall, actualCostOfCall);
    }

    @Test
    public void aClientMakesALocalCallWithADurationOf1MinuteInAWeekendDayOnARushHourAndItsCostIs1Cent(){

        LocalDateTime weekendDayRushHour = LocalDateTime.of(2022,9,3,12,0);
        Client client1          = new Client("Juan", 30.0);
        CallDetails callDetails = new CallDetails(1, new Destination(), weekendDayRushHour);

        Double actualCostOfCall     = client1.makeCall(callDetails, Client.CallType.LOCALCALL);
        Double expectedCostOfCall   = 0.1;

        assertEquals(expectedCostOfCall, actualCostOfCall);
    }


    @Test
    public void aClientMakesThreeCallsSoHisAdditionalCostIncreasesAndItsCallsMadeListAreNowThree(){

        LocalDateTime weekendDayRushHour = LocalDateTime.of(2022,9,22,12,0);
        Client client1          = new Client("Juan", 30.0);
        CallDetails callDetails = new CallDetails(1, new Destination(), weekendDayRushHour);

        client1.makeCall(callDetails, Client.CallType.LOCALCALL);
        client1.makeCall(callDetails, Client.CallType.LOCALCALL);
        client1.makeCall(callDetails, Client.CallType.LOCALCALL);


        Double expectedCostOfCalls = 0.3;
        Double actualCostOfCall = client1.getCostOfCalls();

        assertEquals(expectedCostOfCalls, actualCostOfCall);
        assertEquals(3, client1.getCallsMade().size());
    }
}
