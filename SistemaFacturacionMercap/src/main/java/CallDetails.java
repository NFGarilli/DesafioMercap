import java.time.LocalDate;
import java.time.LocalDateTime;

public class CallDetails {

    Integer callDurationMinutes;
    Destination destination;

    LocalDateTime dateAndTimeOfCall;

    Double costOfCall = 0.0;


    public CallDetails(Integer callDurationMinutes, Destination destination, LocalDateTime dateAndTimeOfCall){
        this.callDurationMinutes = callDurationMinutes;
        this.destination = destination;
        this.dateAndTimeOfCall = dateAndTimeOfCall;
    }

    public Double getCostOfCall() { return costOfCall;}
    public Integer getCallDurationMinutes() {
        return callDurationMinutes;
    }
    public Destination getDestination() {
        return destination;
    }

    public LocalDateTime getLocalDateTime() { return dateAndTimeOfCall; }

    public void setCostOfCall(Double costOfCall) {
        this.costOfCall = costOfCall;
    }


}
