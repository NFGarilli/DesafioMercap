import jdk.jshell.execution.Util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static java.lang.Math.round;

public class LocalCallStrategy implements ICallStrategy {


    @Override
    public Double call(CallDetails callDetails) {

        Double expensiveMinuteCost  = 0.20;
        Double normalMinuteCost     = 0.10;

        return Utility.LocalCallHelper.isExpensiveDayAndTime(callDetails.dateAndTimeOfCall)
                ? callDetails.callDurationMinutes * expensiveMinuteCost
                : callDetails.callDurationMinutes * normalMinuteCost;

    }

}



