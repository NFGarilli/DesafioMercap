import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

class Utility {

    public static class LocalCallHelper {

        public static Boolean isExpensiveDayAndTime(LocalDateTime dateAndTimeOfCall){
            return itsAWorkingDay(dateAndTimeOfCall) && itsRushHour(dateAndTimeOfCall);
        }

        public static Boolean itsAWorkingDay(LocalDateTime dateAndTimeOfCall) {

            DayOfWeek dayOfCall = dateAndTimeOfCall.getDayOfWeek();

            return ((dayOfCall != DayOfWeek.SATURDAY) && (dayOfCall != DayOfWeek.SUNDAY));
        }

        public static Boolean itsRushHour(LocalDateTime dateAndTimeOfCall)
        {
            LocalDateTime eightAmDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.of(7, 59));
            LocalDateTime eightPmDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.of(20, 0));

            return dateAndTimeOfCall.isAfter(eightAmDateTime) && dateAndTimeOfCall.isBefore(eightPmDateTime);

        }
    }

    public static class NumberHelper{

        public static Double toTwoDecimalPlaces(Double d){
            return Math.round(d * 100.0) / 100.0;
        }
    }

}
