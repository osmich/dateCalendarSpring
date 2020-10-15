package com.calendar;

import com.calendar.controller.CustomDate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CalendarApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(CalendarApplication.class, args);

		CustomDate customDate = (CustomDate) ctx.getBean("customDate");
//		customDate.setDate(12, 4, 2007, 9, 15, 0);
		customDate.setDate(10, 1, 2017, 9, 15, 0);
		System.out.println(customDate.displayDate());
	}

}
