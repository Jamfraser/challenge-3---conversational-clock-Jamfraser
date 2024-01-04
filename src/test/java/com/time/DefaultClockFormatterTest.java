package com.time;

import formatter.ClockFormatter;
import formatter.DefaultClockFormatter;
import com.time.ConversationTime;
import org.junit.jupiter.api.Test;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DefaultClockFormatterTest {

    // create a DefaultClockFormatter for our tests
    ClockFormatter formatter = new DefaultClockFormatter();

    @Test
    public void testFormatOnTheHour() {
        // test formatting when the minute is 0 - AM case
        ConversationTime conversationTime = new ConversationTime(LocalTime.of(3,0));
        String formattedTime = formatter.format(conversationTime);

        // assert that the time is formatted correctly into a String
        assertEquals("It's three o'clock AM.", formattedTime);

        // test formatting when the minute is 0 - PM case
        conversationTime = new ConversationTime(LocalTime.of(23, 0));
        formattedTime = formatter.format(conversationTime);
        assertEquals("It's eleven o'clock PM.", formattedTime);
    }

    @Test
    public void testFormatNoon() {
        //test formatting when it is exactly 12 noon
        ConversationTime conversationTime = new ConversationTime(LocalTime.of(12, 0));
        String formattedTime = formatter.format(conversationTime);

        //System.out.println(formattedTime);

        // assert that the time is formatted correctly into a String
        assertEquals("It's noon. Time for lunch!", formattedTime);
    }

    @Test
    public void testFormatMidnight() {
        // test formatting when it is exactly midnight
        ConversationTime conversationTime = new ConversationTime(LocalTime.of(0, 0));
        String formattedTime = formatter.format(conversationTime);

        //System.out.println(formattedTime);

        // assert that the time is formatted correctly into a String
        assertEquals("It's midnight. Spooky!", formattedTime);
    }

    @Test
    public void testFormatHalfPast() {
        // test formatting when the minute is 30
        ConversationTime conversationTime = new ConversationTime(LocalTime.of(21, 30));
        String formattedTime = formatter.format(conversationTime);

        //System.out.println(formattedTime);

        // assert that the time is formatted correctly into a String
        assertEquals("It's half past nine PM.", formattedTime);

        // test when the time is half past noon
        conversationTime = new ConversationTime(LocalTime.of(12, 30));
        formattedTime = formatter.format(conversationTime);
        assertEquals("It's half past noon.", formattedTime);

        // test when the time is half past midnight
        conversationTime = new ConversationTime(LocalTime.of(0, 30));
        formattedTime = formatter.format(conversationTime);
        assertEquals("It's half past midnight.", formattedTime);
    }

    @Test
    public void testFormatQuarterPast() {
        // test formatting when the minute is 15
        ConversationTime conversationTime = new ConversationTime(LocalTime.of(2, 15));
        String formattedTime = formatter.format(conversationTime);

        //System.out.println(formattedTime);

        // assert that the time is formatted correctly into a String
        assertEquals("It's a quarter past two AM.", formattedTime);

        // test when the time is a quarter past noon
        conversationTime = new ConversationTime(LocalTime.of(12, 15));
        formattedTime = formatter.format(conversationTime);
        assertEquals("It's a quarter past noon.", formattedTime);

        // test when the time is a quarter past midnight
        conversationTime = new ConversationTime(LocalTime.of(0, 15));
        formattedTime = formatter.format(conversationTime);
        assertEquals("It's a quarter past midnight.", formattedTime);
    }

    @Test
    public void testFormatQuarterTo() {
        // test formatting when the minute is 45
        ConversationTime conversationTime = new ConversationTime(LocalTime.of(18, 45));
        String formattedTime = formatter.format(conversationTime);

        //System.out.println(formattedTime);

        // assert that the time is formatted correctly into a String
        assertEquals("It's a quarter to seven PM.", formattedTime);

        // test when the time is a quarter to noon
        conversationTime = new ConversationTime(LocalTime.of(11, 45));
        formattedTime = formatter.format(conversationTime);
        assertEquals("It's a quarter to noon.", formattedTime);

        // test when the time is a quarter to midnight
        conversationTime = new ConversationTime(LocalTime.of(23, 45));
        formattedTime = formatter.format(conversationTime);
        assertEquals("It's a quarter to midnight.", formattedTime);
    }

    @Test
    public void testFuzzyResponse() {
        // test formatting when the minute is 5 minutes or less to the next hour
        ConversationTime conversationTime = new ConversationTime(LocalTime.of(9, 58));
        String formattedTime = formatter.format(conversationTime);
        // assert that the time is formatted correctly into a String
        assertEquals("It's almost ten AM.", formattedTime);

        // test formatting when the minute is 10 minutes or less to the next hour, but greater than 5
        conversationTime = new ConversationTime(LocalTime.of(21, 52));
        formattedTime = formatter.format(conversationTime);
        // assert that the time is formatted correctly into a String
        assertEquals("It's 8 minutes to ten PM.", formattedTime);

        // test formatting when the minute is less than 5 minutes past the hour
        conversationTime = new ConversationTime(LocalTime.of(6, 3));
        formattedTime = formatter.format(conversationTime);
        // assert that the time is formatted correctly into a String
        assertEquals("It's just past six AM.", formattedTime);

        // test formatting when the minute is 10 minutes or less past the hour, but greater than 5
        conversationTime = new ConversationTime(LocalTime.of(23, 8));
        formattedTime = formatter.format(conversationTime);
        // assert that the time is formatted correctly into a String
        assertEquals("It's 8 minutes past eleven PM.", formattedTime);
    }

    @Test
    public void testFuzzyResponsesForNoonAndMidnight() {
        // test formatting when the minute 5 minutes or less to noon
        ConversationTime conversationTime = new ConversationTime(LocalTime.of(11, 55));
        String formattedTime = formatter.format(conversationTime);
        // assert that the time is formatted correctly into a String
        assertEquals("It's almost noon.", formattedTime);

        // test formatting when the minute is 10 minutes or less to noon, but greater than 5
        conversationTime = new ConversationTime(LocalTime.of(11, 51));
        formattedTime = formatter.format(conversationTime);
        // assert that the time is formatted correctly into a String
        assertEquals("It's 9 minutes to noon.", formattedTime);

        // test formatting when the minute 5 minutes or less to midnight
        conversationTime = new ConversationTime(LocalTime.of(23, 55));
        formattedTime = formatter.format(conversationTime);
        // assert that the time is formatted correctly into a String
        assertEquals("It's almost midnight.", formattedTime);

        // test formatting when the minute is 10 minutes or less to midnight, but greater than 5
        conversationTime = new ConversationTime(LocalTime.of(23, 50));
        formattedTime = formatter.format(conversationTime);
        // assert that the time is formatted correctly into a String
        assertEquals("It's 10 minutes to midnight.", formattedTime);
    }

    @Test
    public void testFormatDefault() {

        // test formatting when the minute is not 0, 15, 30 or 45
        ConversationTime conversationTime = new ConversationTime(LocalTime.of(15, 27));
        String formattedTime = formatter.format(conversationTime);

        //System.out.println(formattedTime);

        // assert that the time is formatted correctly into a String
        assertEquals("It's 27 minutes past three o'clock PM.", formattedTime);
    }
}
