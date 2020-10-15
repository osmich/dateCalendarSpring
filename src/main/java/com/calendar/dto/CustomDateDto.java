package com.calendar.dto;

import lombok.Getter;

@Getter
public class CustomDateDto {
    private final int[] monthsArray = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    private final int year;
    private final int month; // range 0 - 11
    private final int day;
    private final int hour;
    private final int minute;
    private final int seconds;

    public CustomDateDto(int day, int month, int year, int hour, int minute, int seconds) {
        if(year < 1700 || year > 2099) {
            throw new IllegalArgumentException("Only supports dates between 1700 and 2099 A.C.");
        }
        if(month > 12 || month < 1) {
            throw new IllegalArgumentException("Bad month value");
        }
        var calendarUtil  = new CalendarUtil();
        if(calendarUtil.isLeapYear(year) && month == 2) {
            if(day > 29 || day < 1) {
                throw new IllegalArgumentException("Bad day value");
            }
        }
        else {
            if(day < 1 || day > monthsArray[month - 1]) {
                throw new IllegalArgumentException("Bad day value");
            }
        }
        if(hour > 23 || hour < 0) {
            throw new IllegalArgumentException("Bad hour value");
        }
        if(minute > 59 || minute < 0) {
            throw new IllegalArgumentException("Bad minute value");
        }
        if(seconds > 59 || seconds < 0) {
            throw new IllegalArgumentException("Bad seconds value");
        }
        this.year = year;
        this.month = month - 1;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.seconds = seconds;

    }


}
