
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class CallDetailsTest {



    @Test
    public void getAACallDetailsCallDurationInMinutes(){

        Integer callDuration = 3;

        Destination sanLuis = new Destination(3.0, "SanLuis");

        LocalDateTime timeAndDateOfCall = LocalDateTime.now();

        CallDetails callDetails = new CallDetails(callDuration, sanLuis, timeAndDateOfCall);

        Integer actualCallDuration = callDetails.callDurationMinutes;

        assertEquals(callDuration, actualCallDuration);

    }

    @Test
    public void getACallDetailsDestination(){

        Destination sanLuis = new Destination(3.0,  "SanLuis");

        LocalDateTime timeAndDateOfCall = LocalDateTime.now();

        CallDetails callDetails = new CallDetails(0, sanLuis, timeAndDateOfCall);

        assertEquals(callDetails.destination, sanLuis);

    }

}

