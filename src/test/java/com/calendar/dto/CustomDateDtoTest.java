package com.calendar.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomDateDtoTest {

    @Test
    public void correctDateTest() {
        var customDate = new CustomDateDto(17, 6, 1997, 4, 43, 0);
    }

}