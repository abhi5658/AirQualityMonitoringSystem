package com.tcs.aqi.beans;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class SCL {
	private String state;
	private String city, location;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date todate, fromdate;

	public void setState(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCity() {
		return city;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLocation() {
		return location;
	}

	public Date getTodate() {
		return todate;
	}

	public void setTodate(String todate) {

		this.todate = Date.valueOf(todate);
	}

	public Date getFromdate() {
		return fromdate;
	}

	public void setFromdate(String fromdate) {
		this.fromdate = Date.valueOf(fromdate);
	}

}
