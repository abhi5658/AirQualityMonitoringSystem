package com.tcs.aqi.database;

import java.sql.Date;
import java.time.LocalDate;
import java.util.*;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.tcs.aqi.beans.Pollutant;

import com.tcs.aqi.beans.NotificationDetail;

public class Testing {

	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {

		jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public void feedDatabse(String state, String city, String location, Date date, double pm10, double pm2dot5,
			double no2, double o3, double co, double so2, double nh3, double pb, double AQI) {
		String str = "select count(*) from aqitable where stateid = ? and cityid = ? and locationid = ? and date = ?";
		int check = jdbcTemplateObject.queryForObject(str, new Object[] { state, city, location, date }, Integer.class);
		System.out.println("check: " + check);
		if (check == 0) {
			String SQL = "insert into aqitable (stateid,cityid,locationid,date,pm10,pm2dot5,no2,o3,co,so2,nh3,pb,aqi)values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			jdbcTemplateObject.update(SQL, state, city, location, date, pm10, pm2dot5, no2, o3, co, so2, nh3, pb, AQI);
		} else {
			String update = "update aqitable set pm10 = ?,pm2dot5 = ?,no2 = ?,o3 = ?,co = ?,so2 = ?,nh3 = ?,pb = ?,aqi = ? where stateid = ? and cityid = ? and locationid = ? and date = ?";
			jdbcTemplateObject.update(update, pm10, pm2dot5, no2, o3, co, so2, nh3, pb, AQI, state, city, location,
					date);
		}
		return;
	}

	public boolean checkAdmin(String username, String password) {
		String admincheck = "select count(*) from admin where username = ? and password = ?";
		int check = jdbcTemplateObject.queryForObject(admincheck, new Object[] { username, password }, Integer.class);// .queryForInt(admincheck,username,password);
		if (check > 0)
			return true;
		else
			return false;
	}

	public Pollutant dateAqi(String state, String city, String location, Date date, Date todate, Date fromdate) {
		System.out.println("inside dateaqi function");
		Pollutant pollutant;
		ArrayList<Date> list;
		if (todate.equals(fromdate)) {
			String str = "select * from aqitable where stateid = ? and cityid = ? and locationid = ? and date <= ?";
			// Pollutant pollutant = jdbcTemplateObject.queryForObject(str,new
			// Object[]{state,city,location,date} ,new dateAqiMapper());
			pollutant = jdbcTemplateObject.queryForObject(str, new Object[] { state, city, location, date },
					new dateAqiMapper());
			System.out.println("\n\n" + pollutant.getco() + " " + pollutant.getnh3() + " " + pollutant.getno2() + " "
					+ pollutant.geto3() + " " + pollutant.getpb() + " " + pollutant.getpm10() + " "
					+ pollutant.getpm2dot5() + " " + pollutant.getso2() + "\n\n");
			System.out.println(pollutant.getDateAqi());
			list = new ArrayList<Date>(pollutant.getDateAqi().keySet());
		} else {
			System.out.println("inside else.");
			String str = "select * from aqitable where stateid = ? and cityid = ? and locationid = ? and date >= ? and date <= ?";
			pollutant = jdbcTemplateObject.queryForObject(str, new Object[] { state, city, location, fromdate, todate },
					new dateAqiMapper());
			System.out.println("\n\n" + pollutant.getco() + " " + pollutant.getnh3() + " " + pollutant.getno2() + " "
					+ pollutant.geto3() + " " + pollutant.getpb() + " " + pollutant.getpm10() + " "
					+ pollutant.getpm2dot5() + " " + pollutant.getso2() + "\n\n");
			System.out.println(pollutant.getDateAqi());
			list = new ArrayList<Date>(pollutant.getDateAqi().keySet());
		}
		Collections.sort(list);
		// System.out.println("pm10: "+pollutant.getpm10());
		System.out.println("Date list " + list);
		pollutant.setDate(list);
		pollutant.setListSize(list.size());
		System.out.println("returning value.");
		return pollutant;

	}

	public boolean addSCL(String state, String city, String location) {

		int staterows = jdbcTemplateObject.queryForObject("select count(*) from statemaster where state = ?",
				new Object[] { state }, Integer.class);// .queryForInt("select
														// count(*) from
														// statemaster where
														// state = ?", state);
		if (staterows == 0) {
			jdbcTemplateObject.update("insert into statemaster (state) values (?)", state);
			System.out.println("State entered." + staterows);
		}
		String stateid = (String) jdbcTemplateObject.queryForObject("select stateid from statemaster where state = ?",
				new Object[] { state }, String.class);
		int cityrows = jdbcTemplateObject.queryForObject(
				"select count(*) from citymaster where city = ? and stateid = ?", new Object[] { city, stateid },
				Integer.class);// .queryForInt("select count(*) from citymaster
								// where city = ? and stateid = ?",
								// city,stateid);
		if (cityrows == 0) {
			jdbcTemplateObject.update("insert into citymaster (stateid,city) values (?,?)", stateid, city);
			System.out.println("City entered." + cityrows);
		}
		String cityid = (String) jdbcTemplateObject.queryForObject("select cityid from citymaster where city = ?",
				new Object[] { city }, String.class);
		int locationrows = jdbcTemplateObject.queryForObject("select count(*) from locationmaster where location = ?",
				new Object[] { location }, Integer.class);
		if (locationrows == 0) {
			jdbcTemplateObject.update("insert into locationmaster (stateid,cityid,location) values (?,?,?)", stateid,
					cityid, location);
			System.out.println("Location entered." + locationrows);
		}
		return true;
	}

	public boolean addUser(String fName, String email, String password, String state, String city, String location) {

		int check = jdbcTemplateObject.queryForObject("select count(*) from userdetail where email = ?",
				new Object[] { email }, Integer.class);
		if (check > 0)
			return true;
		else {
			int staterows = jdbcTemplateObject.queryForObject("select count(*) from statemaster where state = ?",
					new Object[] { state }, Integer.class);
			if (staterows == 0) {
				jdbcTemplateObject.update("insert into statemaster (state) values (?)", state);
			}
			String stateid = (String) jdbcTemplateObject.queryForObject(
					"select stateid from statemaster where state = ?", new Object[] { state }, String.class);
			int cityrows = jdbcTemplateObject.queryForObject(
					"select count(*) from citymaster where city = ? and stateid = ?", new Object[] { city, stateid },
					Integer.class);
			if (cityrows == 0) {
				jdbcTemplateObject.update("insert into citymaster (stateid,city) values (?,?)", stateid, city);
			}
			String cityid = (String) jdbcTemplateObject.queryForObject("select cityid from citymaster where city = ?",
					new Object[] { city }, String.class);
			int locationrows = jdbcTemplateObject.queryForObject(
					"select count(*) from locationmaster where location = ?", new Object[] { location }, Integer.class);
			if (locationrows == 0) {
				jdbcTemplateObject.update("insert into locationmaster (stateid,cityid,location) values (?,?,?)",
						stateid, cityid, location);
			}
			String locationid = (String) jdbcTemplateObject.queryForObject(
					"select locationid from locationmaster where location = ?", new Object[] { location },
					String.class);
			jdbcTemplateObject.update(
					"INSERT INTO userdetail (name, email, password, stateid, cityid, locationid) VALUES (?, ?, ?, ?, ?, ?);",
					fName, email, password, stateid, cityid, locationid);
			return false;
		}
	}

	public boolean checkUser(String username, String password) {
		String admincheck = "select count(*) from userdetail where email = ? and password = ?";
		int check = jdbcTemplateObject.queryForObject(admincheck, new Object[] { username, password }, Integer.class);// .queryForInt(admincheck,username,password);
		if (check > 0)
			return true;
		else
			return false;
	}

	public void addCron() {

		jdbcTemplateObject.update("delete from notification");
		NotificationDetail nd = jdbcTemplateObject.queryForObject(
				"select date,aqi,stateid,cityid,locationid from aqitable where aqi > ?", new Object[] { 120 },
				new NotificationDeatailMapper());
	}

	public void addNotification(Date date, double aqi, String state, String city, String loc) {
		jdbcTemplateObject.update("insert into notification values(?,?,?,?,?)", date, aqi, state, city, loc);
	}

	public boolean notification(Date date) {
		int check = jdbcTemplateObject.queryForObject("select count(*) from aqitable where date = ?",
				new Object[] { date }, Integer.class);
		if (check > 0)
			return true;
		else
			return false;
	}

	public String getstate(String stateid) {
		System.out.println("The stateid : " + stateid);

		String state = jdbcTemplateObject.queryForObject("select state from statemaster where stateid = ?",
				new Object[] { stateid }, String.class);
		System.out.println("The state : " + state);
		return state;
	}

	public String getcity(String cityid) {
		System.out.println("The cityid : " + cityid);

		String city = (String) jdbcTemplateObject.queryForObject("select city from citymaster where cityid = ?",
				new Object[] { cityid }, String.class);
		System.out.println("The cityid : " + cityid);
		return city;

	}

	public String getlocation(String locationid) {
		System.out.println("The locationid : " + locationid);
		String loc = jdbcTemplateObject.queryForObject("select location from locationmaster where locationid = ?",
				new Object[] { locationid }, String.class);
		System.out.println("The location : " + loc);
		return loc;

	}

}
