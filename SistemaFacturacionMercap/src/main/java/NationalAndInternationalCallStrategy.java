import static java.lang.Math.cos;
import static java.lang.Math.round;

public class NationalAndInternationalCallStrategy implements ICallStrategy{

    @Override
    public Double call(CallDetails callDetails) {

        Integer callDurationMinutes  = callDetails.getCallDurationMinutes();
        Double costPerMinute         = callDetails.getDestination().getCostPerMinute();

        return Utility.CallHelper.costOfCall(callDurationMinutes, costPerMinute);
    }




}
