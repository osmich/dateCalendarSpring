package com.calendar.controller;

import com.calendar.dto.CustomDateDto;
import com.calendar.formatters.DateFormatter;
import com.calendar.languages.LocaleNames;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomDate {

    private DateFormatter dateFormatter;
    private LocaleNames localeNames;
    @Setter
    private CustomDateDto customDateDto;

    @Autowired
    public void setDateFormatter(DateFormatter dateFormatter) {
        this.dateFormatter = dateFormatter;
    }

    @Autowired
    void setLocaleNames(LocaleNames localeNames) {
        this.localeNames = localeNames;
    }


    public void setDate(int day, int month, int year, int hour, int minute, int seconds) {
        this.customDateDto = new CustomDateDto(day, month, year, hour, minute, seconds);
    }


    public String displayDate() {
        if(customDateDto == null) {
            throw new NullPointerException("Date not yet initialized");
        }
        return dateFormatter.displayDate(customDateDto, localeNames);
    }


}
