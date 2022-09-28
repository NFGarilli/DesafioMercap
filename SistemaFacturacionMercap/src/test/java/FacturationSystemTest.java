import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class FacturationSystemTest {



    @Test
    public void aClientMakesAnInternationalCallToJapanWithADurationOf1MinuteAndItsCostIsOf15() {

        FacturationSystem facturationSystem = new FacturationSystem();

        Destination japan = new Destination(15.0, "japan");
        Destination korea = new Destination(12.5, "korea");
        Destination quilmes = new Destination(3.0, "quilmes");

        LocalDateTime weekDayRushHour    = LocalDateTime.of(2022,9,28,12,0);
        LocalDateTime weekendDayRushHour = LocalDateTime.of(2022,9,22,12,0);

        Client client1          = new Client("Juan", 30.0);
        Client client2          = new Client("Camila", 50.0);
        facturationSystem.clientsList.add(client1);
        facturationSystem.clientsList.add(client2);

        CallDetails callDetails1 = new CallDetails(1, japan, LocalDateTime.now());
        CallDetails callDetails2 = new CallDetails(4, korea, weekDayRushHour);
        CallDetails callDetails3 = new CallDetails(16, quilmes, weekendDayRushHour);

        client1.makeCall(callDetails1, Client.CallType.NATIONALORINTERNATIONALCALL);
        client1.makeCall(callDetails2, Client.CallType.NATIONALORINTERNATIONALCALL);
        client2.makeCall(callDetails3, Client.CallType.LOCALCALL);

        Double actualMonthlyIncome   = facturationSystem.monthlyFacturation();

        Double expectedMonthlyIncome = 146.6;
        //Expected monthly income is all clients baseCost + their callCosts.
        // client1.getBaseCost() + client1.getCostOfCalls() + client2.getBaseCost() + client2.getCostOfCalls();
        assertEquals(expectedMonthlyIncome, actualMonthlyIncome);
    }
}
