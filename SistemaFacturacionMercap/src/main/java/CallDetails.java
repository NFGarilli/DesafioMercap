import java.time.LocalDate;
import java.time.LocalDateTime;

public class CallDetails {

    Integer callDurationMinutes;
    Destination destination;
    LocalDateTime dateAndTimeOfCall;


    public CallDetails(Integer callDurationMinutes, Destination destination, LocalDateTime dateAndTimeOfCall){
        this.callDurationMinutes = callDurationMinutes;
        this.destination = destination;
        this.dateAndTimeOfCall = dateAndTimeOfCall;
    }



    public Integer getCallDurationMinutes() {
        return callDurationMinutes;
    }

    public Destination getDestination() {
        return destination;
    }

    public LocalDateTime getDateAndTimeOfCall() { return dateAndTimeOfCall; }




}
