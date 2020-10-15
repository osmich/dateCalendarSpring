package com.calendar.languages;

import org.springframework.stereotype.Component;

@Component
public class LocaleNamesEnglishImpl implements LocaleNames {
    private final String[] weekDays = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
    private final String[] monthNames = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};


    public String getDayOfAWeek(int day) {
        if(day < 0 || day > 6) {
            throw new IllegalArgumentException("Incorrect day of a week index");
        }
        return weekDays[day];
    }

    public String getMonthName(int month) {
        if(month < 0 || month > 11) {
            throw new IllegalArgumentException("Incorrect month index");
        }
        return monthNames[month];
    }
}
