package com.time;

import java.time.LocalTime;
public class ConversationTime {

        private final LocalTime time;

        public ConversationTime(LocalTime time) {
            this.time = time;
        }

        // add methods to retrieve hours, minutes, etc

    @Override
    public String toString() {
            // customize later
            return time.toString();
    }
}
