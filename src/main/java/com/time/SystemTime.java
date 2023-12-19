package com.time;

import java.time.LocalTime;

public class SystemTime implements TimeProvider {
    @Override
    // override the interface method to provide the current time using LocalTime.now()
    public LocalTime getCurrentTime() {
        return LocalTime.now();
    }
}
