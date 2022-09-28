import static java.lang.Math.round;

public class NationalAndInternationalCallStrategy implements ICallStrategy{

    @Override
    public Double call(CallDetails callDetails) {
        //NationalAndInternationalCallDetails castedCallDetails = (NationalAndInternationalCallDetails)callDetails;

        return callDetails.destination.getCostPerMinute() * callDetails.getCallDurationMinutes();

    }


}
