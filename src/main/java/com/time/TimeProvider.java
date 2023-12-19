package com.time;

import java.time.LocalTime;
public interface TimeProvider {
    // declares a single method that returns the current time as a LocalTime object
    LocalTime getCurrentTime();
}
