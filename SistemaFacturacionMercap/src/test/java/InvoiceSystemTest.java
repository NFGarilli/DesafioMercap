import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class InvoiceSystemTest {



    @Test
    public void aClientMakesAnInternationalCallToJapanWithADurationOf1MinuteAndItsCostIsOf15() {

        InvoiceSystem invoiceSystem = new InvoiceSystem();

        Destination japan = new Destination(15.0, "japan");
        Destination korea = new Destination(12.5, "korea");
        Destination quilmes = new Destination(3.0, "quilmes");

        LocalDateTime weekDayRushHour    = LocalDateTime.of(2022,9,28,12,0);
        LocalDateTime weekendDayRushHour = LocalDateTime.of(2022,9,24,12,0);

        Client client1          = new Client("Juan", 30.0);
        Client client2          = new Client("Camila", 50.0);
        invoiceSystem.clientsList.add(client1);
        invoiceSystem.clientsList.add(client2);

        CallDetails callDetails1 = new CallDetails(1, japan, LocalDateTime.now());
        CallDetails callDetails2 = new CallDetails(4, korea, weekDayRushHour);
        CallDetails callDetails3 = new CallDetails(16, quilmes, weekendDayRushHour);

        client1.makeCall(callDetails1, Client.CallType.NATIONALORINTERNATIONALCALL);
        client1.makeCall(callDetails2, Client.CallType.NATIONALORINTERNATIONALCALL);
        client2.makeCall(callDetails3, Client.CallType.LOCALCALL);

        Double actualMonthlyIncome   = invoiceSystem.monthlyInvoice();

        Double expectedMonthlyIncome = invoiceSystem.getClientMonthlyBill(client1) + invoiceSystem.getClientMonthlyBill(client2);
        //Expected monthly income is all clients baseCost + all their callCosts.

        assertEquals(expectedMonthlyIncome, actualMonthlyIncome);
    }

    @Test
    public void givenAClientTheSystemProvidesHisMonthlyFacturation() {

        InvoiceSystem invoiceSystem = new InvoiceSystem();

        Destination japan = new Destination(15.0, "japan");
        Destination korea = new Destination(12.5, "korea");

        LocalDateTime weekDayRushHour    = LocalDateTime.of(2022,9,28,12,0);

        Client client1          = new Client("Juan", 30.0);
        invoiceSystem.clientsList.add(client1);


        CallDetails callDetails1 = new CallDetails(1, japan, LocalDateTime.now());
        CallDetails callDetails2 = new CallDetails(4, korea, weekDayRushHour);

        client1.makeCall(callDetails1, Client.CallType.NATIONALORINTERNATIONALCALL);
        client1.makeCall(callDetails2, Client.CallType.NATIONALORINTERNATIONALCALL);

        Double actualClientMonthlyIncome   = invoiceSystem.getClientMonthlyBill(client1);
        Double expectedClientMonthlyIncome = 95.0;
        //expected client monthly income in this case is calculated by clients base cost (30) + the cost of the calls he has made. (1 minute to japan, 4 minutes to korea)


        assertEquals(actualClientMonthlyIncome, expectedClientMonthlyIncome);
    }
}
