package com.calendar.formatters;

import com.calendar.dto.CustomDateDto;
import com.calendar.languages.LocaleNames;

public interface DateFormatter {
    public String displayDate(CustomDateDto date, LocaleNames localeNames);
}
