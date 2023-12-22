package com.time;

import java.time.LocalTime;

// interface for SystemTime to extend
public interface TimeProvider {
    // declares a single method that returns the current time as a LocalTime object
    LocalTime getCurrentTime();
}
