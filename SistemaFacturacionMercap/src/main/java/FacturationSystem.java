import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class FacturationSystem {

    public List<Client> clientsList = new ArrayList<Client>();

    public FacturationSystem(){

    }

    public Double monthlyFacturation(){

        Double monthlyFacturation = 0.0;

        for (Client client : clientsList){
            monthlyFacturation += client.getBaseCost() + client.getCostOfCalls();
            System.out.println("Clients name: "             + client.getName());
            System.out.println("Clients base cost: $"        + client.getBaseCost());
            System.out.println("Clients additional costs: $" + client.getCostOfCalls());
            this.showClientCallDetails(client.getCallsMade());

        }

        System.out.println("This month facturation total: $" + monthlyFacturation);
        return monthlyFacturation;

    }

    public void showClientCallDetails(List<CallDetails> callsMade){
        for (CallDetails callMade : callsMade){
            System.out.println("Duration of call: " + callMade.getCallDurationMinutes() + " Minutes" + " - Destination: " + callMade.getDestination().getDestinationName());

        }
    }


}
