package com.tcs.aqi.services;


import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import java.util.*;
import java.sql.Date;
import java.time.LocalDate;



import org.springframework.stereotype.Service;

import com.tcs.aqi.controllers.RequestController;
import com.tcs.aqi.database.Testing;
 
@Service
@EnableScheduling
public class cronJob
{
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	Testing testing = (Testing)context.getBean("testing");
	int value = 5;
	
//    @Scheduled(cron="* */1 * * * ?")
    @Scheduled(cron="0 0/1 * ? * *")
    public void demoServiceMethod()
    {/*
    	Date date = java.sql.Date.valueOf(LocalDate.now());
    	boolean check =  testing.notification(Date.valueOf(LocalDate.now()));
    	
    	RequestController req= new RequestController();
    	req.noti();
        System.out.println("+-+-+-+-+----Method executed. Current time is :: "+ new java.util.Date()+"------+-+-+-+");
        testing.addCron(date,value);
        value++;
        System.out.println("Done entering into database.......");
    */}
}
/*    	
 * Keep an eye at the console(It will make you understand what's happening)
 * wait for the output on console ;)
 * then see the changes in the database in cronhere table
 * 
 * http://www.quartz-scheduler.org/documentation/quartz-1.x/tutorials/crontrigger
 * 
 * 
 * "0 0 0 * * ?" - for everyday at 12:00 AM at night----------------------------probably
 * 
 * 
Field Name		Mandatory	Allowed Values		Allowed Special Characters
Seconds			YES			0-59				, - * /
Minutes			YES			0-59				, - * /
Hours			YES			0-23				, - * /
Day of month	YES			1-31				, - * ? / L W
Month			YES			1-12 or JAN-DEC		, - * /
Day of week		YES			1-7 or SUN-SAT		, - * ? / L #



0 0 12 * * ?		Fire at 12pm (noon) every day
0 15 10 ? * *		Fire at 10:15am every day
0 15 10 * * ?		Fire at 10:15am every day
0 15 10 * * ? *		Fire at 10:15am every day
0 15 10 * * ? 2005	Fire at 10:15am every day during the year 2005
0 * 14 * * ?		Fire every minute starting at 2pm and ending at 2:59pm, every day
0 0/5 14 * * ?		Fire every 5 minutes starting at 2pm and ending at 2:55pm, every day
0 0/5 14,18 * * ?	Fire every 5 minutes starting at 2pm and ending at 2:55pm, AND fire every 5 minutes starting at 6pm and ending at 6:55pm, every day
0 0-5 14 * * ?		Fire every minute starting at 2pm and ending at 2:05pm, every day
0 10,44 14 ? 3 WED	Fire at 2:10pm and at 2:44pm every Wednesday in the month of March.
0 15 10 ? * MON-FRI	Fire at 10:15am every Monday, Tuesday, Wednesday, Thursday and Friday
0 15 10 15 * ?		Fire at 10:15am on the 15th day of every month
0 15 10 L * ?		Fire at 10:15am on the last day of every month
0 15 10 ? * 6L		Fire at 10:15am on the last Friday of every month
0 15 10 ? * 6L		Fire at 10:15am on the last Friday of every month
0 15 10 ? * 6L 2002-2005	Fire at 10:15am on every last friday of every month during the years 2002, 2003, 2004 and 2005
0 15 10 ? * 6#3		Fire at 10:15am on the third Friday of every month
0 0 12 1/5 * ?		Fire at 12pm (noon) every 5 days every month, starting on the first day of the month.
0 11 11 11 11 ?		Fire every November 11th at 11:11am.
*/ 
