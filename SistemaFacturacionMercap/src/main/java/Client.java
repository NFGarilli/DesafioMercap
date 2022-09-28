import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Client {

    public String name;
    public Double baseCost;
    public Double costOfCalls = 0.0;
    public List<CallDetails> callsMade = new ArrayList<CallDetails>();
    public ICallStrategy callStrategy;



    public Client(String name, Double baseCost){
        this.name = name;
        this.baseCost = baseCost;
    }

    public enum CallType {
        LOCALCALL, NATIONALORINTERNATIONALCALL
    }

    public Double makeCall(CallDetails callDetails, CallType callType){

        setCallStrategy(callType);
        Double costOfThisCall = this.callStrategy.call(callDetails);

        this.costOfCalls += costOfThisCall;
        this.callsMade.add(callDetails);
        return costOfThisCall;
    }



    public void setCostOfCalls(Double costOfCalls) {
        this.costOfCalls = costOfCalls;
    }

    public String getName() {
        return name;
    }

    public Double getCostOfCalls() {
        return Math.round(costOfCalls * 100.0) / 100.0;
    }

    public Double getBaseCost() {
        return baseCost;
    }

    public void setBaseCost(Double baseCost) {
        this.baseCost = baseCost;
    }

    public void setName(String nombre) {
        this.name = nombre;
    }

    public List<CallDetails> getCallsMade() {
        return callsMade;
    }

    public void setCallStrategy(CallType callType) {


        ICallStrategy callStrategy = callType.equals(CallType.LOCALCALL)
                ? new LocalCallStrategy()
                : new NationalAndInternationalCallStrategy();

        this.callStrategy = callStrategy;


    }
}
