package com.time;

import java.time.LocalTime;
public class ConversationTime {

    // variable to hold the LocalTime
    private final LocalTime time;

    // constructor where we can pass in a specific time
    public ConversationTime(LocalTime time) {
        this.time = time;
    }

    // methods to retrieve hours, minutes, etc
    public int getHours() {
        return time.getHour();
    }

    public int getMinutes() {
        return time.getMinute();
    }

    @Override
    public String toString() {
        // customize later
        return time.toString();
    }
}
