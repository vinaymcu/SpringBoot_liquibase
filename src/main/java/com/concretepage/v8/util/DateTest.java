package com.concretepage.v8.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;

public class DateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate today = LocalDate.now();
		System.out.println("Current Date="+today);
		System.out.println("Year "+today.getYear()+" is Leap Year? "+today.isLeapYear());
		
		LocalTime time = LocalTime.now();
		System.out.println("Current Time="+time);
		
		LocalDateTime today1 = LocalDateTime.now();
		System.out.println("Current DateTime="+today1);
		
		Instant timestamp = Instant.now();
		System.out.println("Current Timestamp = "+timestamp);
		
		
		LocalDate firstDay_2014 = LocalDate.of(2014, Month.JANUARY, 1);
		System.out.println("Specific Date="+firstDay_2014);
		
		LocalDate todayKolkata = LocalDate.now(ZoneId.of("Asia/Kolkata"));
		System.out.println("Current Date in IST="+todayKolkata);
		
		LocalDate hundredDay2014 = LocalDate.ofYearDay(2019, 10);
		System.out.println("10th day of 2019="+hundredDay2014);
		
	}

}
