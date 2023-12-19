package com.time;

import formatter.ClockFormatter;
import formatter.DefaultClockFormatter;

public class ConversationalClock {
    // the conversational clock will contain a TimeProvider and a ClockFormatter
    private final TimeProvider timeProvider;
    private final ClockFormatter clockFormatter;

    // constructor that takes a TimeProvider and a ClockFormatter as dependencies
    public ConversationalClock(TimeProvider timeProvider, ClockFormatter clockFormatter) {
        this.timeProvider = timeProvider;
        this.clockFormatter = clockFormatter;
    }

    public String currentTime() {
        // Get the current time from the TimeProvider
        // Convert it to a conversational format using the ClockFormatter
        // Return the formatted time as a String
        // Example: return "It's three o'clock"

        ConversationTime conversationTime = new ConversationTime(timeProvider.getCurrentTime());
        return clockFormatter.format(conversationTime);
    }

    public static void main(String[] args) {
        // For now, let's create an instance with a SystemTime and DefaultClockFormatter
        ConversationalClock conversationalClock = new ConversationalClock(new SystemTime(), new DefaultClockFormatter());

        // output the current time
        System.out.println(conversationalClock.currentTime());
    }

}