package com.tcs.aqi.database;

import java.sql.Date;
import java.time.LocalDate;
import java.util.*;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.tcs.aqi.beans.Pollutant;

public class Testing {

	private JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(DataSource dataSource){
		
		jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	/*public void insert (String state,String city){
		String SQL = "insert into demo values(?,?)";
		jdbcTemplateObject.update(SQL,state,city);
		return;
	}*/
	public void feedDatabse(String state, String city, String location, Date date, double pm10, double pm2dot5, double no2,
			double o3, double co, double so2, double nh3, double pb, double AQI) {
		String str = "select count(*) from aqitable where stateid = ? and cityid = ? and locationid = ? and date = ?";
		int check = jdbcTemplateObject.queryForObject(str, new Object[] {state,city,location,date}, Integer.class);
		System.out.println("check: "+check);
		if(check == 0)
		{
		String SQL = "insert into aqitable (stateid,cityid,locationid,date,pm10,pm2dot5,no2,o3,co,so2,nh3,pb,aqi)values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplateObject.update(SQL,state,city,location,date,pm10,pm2dot5,no2,o3,co,so2,nh3,pb,AQI);
		}
		else
		{
			String update = "update aqitable set pm10 = ?,pm2dot5 = ?,no2 = ?,o3 = ?,co = ?,so2 = ?,nh3 = ?,pb = ?,aqi = ? where stateid = ? and cityid = ? and locationid = ? and date = ?";
			jdbcTemplateObject.update(update, pm10,pm2dot5,no2,o3,co,so2,nh3,pb,AQI,state,city,location,date);
		}
		return;
	}
	public boolean checkAdmin (String username,String password)
	{
		String admincheck = "select count(*) from admin where username = ? and password = ?";
		int check = jdbcTemplateObject.queryForObject(admincheck, new Object[] {username,password}, Integer.class);//.queryForInt(admincheck,username,password);
		if(check > 0)
			return true;
		else
			return false;
	}
	public Pollutant dateAqi (String state,String city,String location,Date date){
		String str = "select * from aqitable where stateid = ? and cityid = ? and locationid = ? and date <= ?";
		 //Pollutant pollutant = jdbcTemplateObject.queryForObject(str,new Object[]{state,city,location,date} ,new dateAqiMapper());
		 Pollutant pollutant = jdbcTemplateObject.queryForObject(str,new Object[]{state,city,location,date},new dateAqiMapper());
		 System.out.println(pollutant.getDateAqi());
		 ArrayList<Date> list =new ArrayList<Date>(pollutant.getDateAqi().keySet());
		 Collections.sort(list);
		 Collections.reverse(list);
		 //Collections.
		 System.out.println("pm10: "+pollutant.getpm10());
		pollutant.setDate(list);
		return pollutant;
	}
	public boolean addSCL (String state,String city,String location){
		
		int staterows = jdbcTemplateObject.queryForObject("select count(*) from statemaster where state = ?", new Object[] {state}, Integer.class);//.queryForInt("select count(*) from statemaster where state = ?", state);
		if(staterows == 0){
			jdbcTemplateObject.update("insert into statemaster (state) values (?)", state);
			System.out.println("State entered."+staterows);
		}
		String stateid = (String) jdbcTemplateObject.queryForObject(
	            "select stateid from statemaster where state = ?", new Object[] { state }, String.class);
		int cityrows = jdbcTemplateObject.queryForObject("select count(*) from citymaster where city = ? and stateid = ?", new Object[] { city,stateid}, Integer.class);//.queryForInt("select count(*) from citymaster where city = ? and stateid = ?", city,stateid);
		if(cityrows == 0){
			jdbcTemplateObject.update("insert into citymaster (stateid,city) values (?,?)", stateid,city);
			System.out.println("City entered."+cityrows);
		}
		String cityid = (String) jdbcTemplateObject.queryForObject(
	            "select cityid from citymaster where city = ?", new Object[] { city }, String.class);
		int locationrows = jdbcTemplateObject.queryForObject("select count(*) from locationmaster where location = ?", new Object[] {location}, Integer.class);//.queryForInt("select count(*) from locationmaster where location = ?", location);
		if(locationrows == 0){
			jdbcTemplateObject.update("insert into locationmaster (stateid,cityid,location) values (?,?,?)", stateid,cityid,location);
			System.out.println("Location entered."+locationrows);
		}
		return true;
	}
	public boolean addUser(String fName, String lName, String email, String password, String state, String city, String location) {
	
		int check = jdbcTemplateObject.queryForObject("select count(*) from userdetail where email = ?", new Object[] {email}, Integer.class);//.queryForInt("select count(*) from userdetail where email = ?", email);
		if(check > 0)
			return true;
		else{
			jdbcTemplateObject.update("INSERT INTO userdetail (fname, lname, email, password, state, city, location) VALUES (?, ?, ?, ?, ?, ?, ?);", fName,lName,email,password,state,city,location);
			return false;
		}
	}
	public boolean checkUser (String username,String password)
	{
		String admincheck = "select count(*) from userdetail where email = ? and password = ?";
		int check = jdbcTemplateObject.queryForObject(admincheck, new Object[] {username,password}, Integer.class);//.queryForInt(admincheck,username,password);
		if(check > 0)
			return true;
		else
			return false;
	}
	public void addCron(Date date,int value){
		jdbcTemplateObject.update("insert into cronhere (date,value) values (?,?)",date,value);
	}
	public boolean notification(Date date){
		int check = jdbcTemplateObject.queryForObject("select count(*) from aqitable where date = ?", new Object[] {date}, Integer.class);//.queryForInt("select count(*) from userdetail where email = ?", email);
		if(check > 0)
			return true;
		else
			return false;
	}
}
