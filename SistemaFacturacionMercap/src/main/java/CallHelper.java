import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

class Utility {

    public static class CallHelper {

        public static Boolean callIsMadeInAWorkingDayOnRushHour(LocalDateTime dateAndTimeOfCall) {
            return itsAWorkingDay(dateAndTimeOfCall) && itsRushHour(dateAndTimeOfCall);
        }

        public static Boolean itsAWorkingDay(LocalDateTime dateAndTimeOfCall) {

            DayOfWeek dayOfCall = dateAndTimeOfCall.getDayOfWeek();

            return ((dayOfCall != DayOfWeek.SATURDAY) && (dayOfCall != DayOfWeek.SUNDAY));
        }

        public static Boolean itsRushHour(LocalDateTime dateAndTimeOfCall) {

            LocalTime hourAndMinuteOfCall = dateAndTimeOfCall.toLocalTime();
            LocalTime eightAmDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.of(7, 59)).toLocalTime();
            LocalTime eightPmDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.of(20, 0)).toLocalTime();

            return hourAndMinuteOfCall.isAfter(eightAmDateTime) && hourAndMinuteOfCall.isBefore(eightPmDateTime);
        }

        public static Double costOfCall(Integer callDuration, Double costPerMinute) {
            return callDuration * costPerMinute;
        }
    }

    public static class NumberHelper{

        public static Double toTwoDecimalPlaces(Double d){
            return Math.round(d * 100.0) / 100.0;
        }
     }

}
