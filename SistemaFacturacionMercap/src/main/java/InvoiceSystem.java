import java.util.ArrayList;
import java.util.List;

public class InvoiceSystem {

    public List<Client> clientsList = new ArrayList<Client>();

    public InvoiceSystem(){

    }

    public Double monthlyInvoice(){

        Double monthlyInvoice = 0.0;

        for (Client client : clientsList){
            monthlyInvoice += client.getBaseCost() + client.getCostOfCalls();
            System.out.println("Clients name: "             + client.getName());
            System.out.println("Clients base cost: $"        + client.getBaseCost());
            System.out.println("Clients additional costs: $" + client.getCostOfCalls());
            this.showClientCallDetails(client.getCallsMade());
            System.out.println(client.getName() + " total debt for this month: " + this.getClientMonthlyBill(client));
        }
        System.out.println("This month facturation total: $" + monthlyInvoice);
        return monthlyInvoice;
    }

    public void showClientCallDetails(List<CallDetails> callsMade){
        for (CallDetails callMade : callsMade){
            System.out.println("Duration of call: " + callMade.getCallDurationMinutes() + " Minutes" + " - Destination: " + callMade.getDestination().getDestinationName());
        }
    }

    public Double getClientMonthlyBill(Client client){
        return client.getBaseCost() + client.getCostOfCalls();
    }

}
