package com.time;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import com.time.SystemTime;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class SystemTimeTest {

    @Test
    public void shouldTestGetCurrentTime() {
        // create a new SystemTime object for our test
        SystemTime systemTime = new SystemTime();

        // get the current time twice to ensure the result is consistent
        LocalTime currentTime1 = systemTime.getCurrentTime();
        LocalTime currentTime2 = systemTime.getCurrentTime();

        // get the difference between the two times we just recorded in seconds
        long timeDifferenceInSeconds = ChronoUnit.SECONDS.between(currentTime1, currentTime2);
        // assert that the two times we just got are within one second of one another
        assertEquals(0, timeDifferenceInSeconds, "SystemTime should return the same time on subsequent calls");
    }

}
