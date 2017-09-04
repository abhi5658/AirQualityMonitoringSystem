package com.tcs.aqi.beans;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

public class Pollutant {

	private float pm10, pm2dot5, no2, o3, co, so2, nh3, pb;
	private String state;
	private String city, location;
	private int listSize;
	private HashMap<Date, Double> dateAqi = new HashMap<>();
	public ArrayList<Date> date = new ArrayList<>();
	private Date dateForData;

	public Pollutant() {
		dateAqi = new HashMap<Date, Double>();
		date = new ArrayList<Date>();
	}

	public Date getDateForData() {
		return dateForData;
	}

	public void setDateForData(Date dateForData) {
		this.dateForData = dateForData;
	}

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

	public void setpm10(float pm10) {
		this.pm10 = pm10;
	}

	public float getpm10() {
		return pm10;
	}

	public void setpm2dot5(float pm2dot5) {
		this.pm2dot5 = pm2dot5;
	}

	public float getpm2dot5() {
		return pm2dot5;
	}

	public void setno2(float no2) {
		this.no2 = no2;
	}

	public float getno2() {
		return no2;
	}

	public void seto3(float o3) {
		this.o3 = o3;
	}

	public float geto3() {
		return o3;
	}

	public void setco(float co) {
		this.co = co;
	}

	public float getco() {
		return co;
	}

	public void setso2(float so2) {
		this.so2 = so2;
	}

	public float getso2() {
		return so2;
	}

	public void setnh3(float nh3) {
		this.nh3 = nh3;
	}

	public float getnh3() {
		return nh3;
	}

	public void setpb(float pb) {
		this.pb = pb;
	}

	public float getpb() {
		return pb;
	}

	public void setDateAqi(HashMap dateAqi) {
		this.dateAqi = dateAqi;
	}

	public HashMap<Date, Double> getDateAqi() {
		return dateAqi;
	}

	public void setDate(ArrayList date) {
		this.date = date;
	}

	public ArrayList<Date> getDate() {
		return date;
	}

	public void setListSize(int listSize) {
		this.listSize = listSize;
	}

	public int getListSize() {
		return listSize;
	}
}
