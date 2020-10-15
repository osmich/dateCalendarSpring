package com.calendar.formatters;

import com.calendar.dto.CalendarUtil;
import com.calendar.dto.CustomDateDto;
import com.calendar.languages.LocaleNames;
import org.springframework.stereotype.Component;

@Component
public class DateFormatterBasicImpl implements DateFormatter {
    @Override
    public String displayDate(CustomDateDto date, LocaleNames localeNames) {
        var year = date.getYear();
        var month = localeNames.getMonthName(date.getMonth());
        var day = date.getDay();
        var hour = date.getHour();
        var rawMinute = date.getMinute();
        var minute = rawMinute < 10 ? "0" + rawMinute: rawMinute;
        var rawSecond = date.getSeconds();
        var seconds = rawSecond < 10 ? "0" + rawSecond: rawSecond;

        var dayOfAWeek = new CalendarUtil().getDayOfAWeek(date.getYear(), date.getMonth(), date.getDay());

        return String.format("%d/%s/%d %s %d:%s:%s", day, month, year, dayOfAWeek, hour, minute, seconds);
    }
}
