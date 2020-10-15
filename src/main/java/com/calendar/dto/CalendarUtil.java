package com.calendar.dto;

public class CalendarUtil {

    public boolean isLeapYear(int year) {
        return (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0));
    }


    public int getDayOfAWeek(int year, int month, int day) {
        // 1. Take the last two digits of the year.
        // 2. Divide by 4 discarding any fraction.
        int dayOfAWeek = ((year % 100) / 4);
        // 3. Add the day of a month.
        // 4. Add the month key value:
        dayOfAWeek += day + getMonthKeyValue(month);
        // 5. Subtract 1 for January of February of a leap year.
        if(isLeapYear(year) && month < 2) {
            dayOfAWeek -= 1;
        }
        // 6. Add 4 for 1700's, 2 for 1800's, 0 for 1900's, 6 for 2000's.
        dayOfAWeek += getCenturyValue(year);
        // 7. Add last two digits of the year.
        dayOfAWeek += (year % 100);
        // 8. Divide by 7 and take the reminder.
         // Note: 0 is Monday, 1 is Tuesday and so on;//////////////////1 is Sunday, 2 is Monday and so on.
        return dayOfAWeek % 7;
    }

    public int getWeekNumber(int year, int month, int day) {
        return -1;
    }


    protected int getMonthKeyValue(int month) {
        if(month < 3) {
            return 133;
        }
        else if(month < 6) {
            return 25;
        }
        else if(month < 9) {
            return 36;
        }
        else {
            return 146;
        }
    }

    protected int getCenturyValue(int year) {
        int century = year / 100;
        if(century == 17) {
            return 4;
        }
        else if(century == 18) {
            return 2;
        }
        else if(century == 19) {
            return 0;
        }
        else if(century == 20) {
            return 6;
        }
        else {
            throw new IllegalArgumentException("Only supports dates between 1700 and 2099 A.C.");
        }
    }



}
