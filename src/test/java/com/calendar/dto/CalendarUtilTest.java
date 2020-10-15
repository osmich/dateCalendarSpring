package com.calendar.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalendarUtilTest {

    @Test
    public void sampleGetDayOfAWeekTest() {
        // given
        var calendarUtil = new CalendarUtil();
        // when
        var dayOfAWeek = calendarUtil.getDayOfAWeek(2020, 7, 10);
        // then
        assertEquals(2, dayOfAWeek);
    }

    @Test
    public void sampleTest() {
        int year = 2019;
        int month = 7;
        int  day = 10;
        var calendarUtil = new CalendarUtil();
        // 1. Take the last two digits of the year.
        // 2. Divide by 4 discarding any fraction.
        int dayOfAWeek = ((year % 100) / 4);
        // 3. Add the day of a month.
        // 4. Add the month key value:
        dayOfAWeek += day + calendarUtil.getMonthKeyValue(month);

        // 5. Subtract 1 for January of February of a leap year.
        if(calendarUtil.isLeapYear(year) && month < 2) {
            dayOfAWeek -= 1;
        }
        assertEquals(50, dayOfAWeek);
        // 6. Add 4 for 1700's, 2 for 1800's, 0 for 1900's, 6 for 2000's.
        dayOfAWeek += calendarUtil.getCenturyValue(year);
        assertEquals(56, dayOfAWeek);

        // 7. Add last two digits of the year.
        dayOfAWeek += (year % 100);
        assertEquals(75, dayOfAWeek);

//        // 8. Divide by 7 and take the reminder.
//        // Note: 1 is Sunday, 2 is Monday and so on.
//        dayOfAWeek % 7;
    }

}