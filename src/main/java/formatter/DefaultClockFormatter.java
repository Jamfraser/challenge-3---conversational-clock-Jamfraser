package formatter;

import com.time.ConversationTime;
import java.time.LocalTime;
public class DefaultClockFormatter implements ClockFormatter{

    // Overridden method to return the time in a conversational tone
    @Override
    public String format(ConversationTime conversationTime) {
        // get the hour and minute from the conversationTime
        int hour = conversationTime.getHours();
        int minute = conversationTime.getMinutes();

        // if-else statement to determine what kind of format the time should be returned in
        // use custom messages for exactly noon or midnight
        // uses methods defined below for the remaining generic cases
        if(hour == 12 && minute==0) {
            return String.format("It's noon. Time for lunch!");
        } else if (hour==0 && minute==0) {
            return String.format("It's midnight. Spooky!");
        } else if (minute==0) {
            return formatOnTheHour(hour);
        } else if (minute==30) {
            return formatHalfPast(hour);
        } else if (minute==15) {
            return formatQuarterPast(hour);
        } else if (minute==45) {
            return formatQuarterTo(hour);
        } else {
            // default case
            return formatDefault(minute, hour);
        }
    }

    // array to hold string representations of each possible hour
    private static final String[] HOUR_WORDS = {
            "midnight", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven",
            "noon", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven"
    };

    // helper method to convert hour to word
    // determines if the hour is AM or PM
    private String[] hourToWord(int hour) {
        // use ternary operator to assign value to the hour - will always be expressed as an int between 1 and 12
        int hour12 = (hour % 12 == 0) ? 12 : hour %12;
        // use ternary operator to choose a String - AM if the hour is less than 12, PM if it is greater than 12
        String amPm = (hour < 12) ? "AM" : "PM";
        // retrieves the word representation of the hour from the HOUR_WORDS array
        String wordRepresentation = HOUR_WORDS[hour12];
        // returns a final String array made of the word representation and either AM or PM
        return new String[]{wordRepresentation, amPm};
    }

    // helper method to convert minute to word
    private String minuteToWord(int minute) {
        return String.valueOf(minute);
    }

    // methods to use inside the if-else statement above to return proper formats
    // on the hour
    private String formatOnTheHour(int hour) {
        // call hourToWord to get the word representation of the hour and AM/PM status
        String[] hourInfo = hourToWord(hour);
        String wordRepresentation = hourInfo[0];
        String amPm = hourInfo[1];
        // return our conversational string
        return String.format("It's %s o'clock %s.", wordRepresentation, amPm);
    }

    // half past
    private String formatHalfPast(int hour) {
        // call hourToWord to get the word representation of the hour and AM/PM status
        String[] hourInfo = hourToWord(hour);
        String wordRepresentation = hourInfo[0];
        // special consideration if the hour is noon or midnight
        if (hour == 12) {
            return String.format("It's half past noon.");
        } else if (hour == 0) {
            return String.format("It's half past midnight.");
        } else { // otherwise return our conversational string including AM/PM status
            String amPm = hourInfo[1];
            return String.format("It's half past %s %s.", wordRepresentation, amPm);
        }
    }

    // quarter past
    private String formatQuarterPast(int hour) {
        // call hourToWord to get the word representation of the hour and AM/PM status
        String[] hourInfo = hourToWord(hour);
        String wordRepresentation = hourInfo[0];
        // special consideration if the hour is noon or midnight
        if (hour == 12) {
            return String.format("It's a quarter past noon.");
        } else if (hour == 0) {
            return String.format("It's a quarter past midnight.");
        } else { // otherwise return our conversational string including AM/PM status
            String amPm = hourInfo[1];
            return String.format("It's a quarter past %s %s.", wordRepresentation, amPm);
        }
    }

    // quarter to
    private String formatQuarterTo(int hour) {
        // call hourToWord to get the word representation of the hour and AM/PM status
        String[] hourInfo = hourToWord(hour);
        String wordRepresentation = hourInfo[0];
        // special consideration if the hour is noon or midnight
        if (hour == 11) {
            return String.format("It's a quarter to noon.");
        } else if (hour == 23) {
            return String.format("It's a quarter to midnight.");
        } else { // otherwise return our conversational string including AM/PM status
            String amPm = hourInfo[1];
            // use modulo to ensure the next hour is within 12 hours
            int nextHour = (hour + 1) % 12;
            String nextHourWord = HOUR_WORDS[nextHour];
            return String.format("It's a quarter to %s %s.", nextHourWord, amPm);
        }
    }

    // default format
    private String formatDefault(int minute, int hour) {
        // call hourToWord to get the word representation of the hour and AM/PM status
        String[] hourInfo = hourToWord(hour);
        String wordRepresentation = hourInfo[0];
        String amPm = hourInfo[1];
        // return our conversational string
        return String.format("It's %s minutes past %s o'clock %s.", minuteToWord(minute), wordRepresentation, amPm);
    }
}
