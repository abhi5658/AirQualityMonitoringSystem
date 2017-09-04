package com.tcs.aqi.database;

import java.lang.reflect.Field;
import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.ModelMap;

import com.tcs.aqi.beans.Pollutant;

public class AQICalculation {
	static double pm10, pm2dot5, no2, o3, co, so2, nh3, pb;
	static String state, city, location;
	static HashMap<String, Double> concentration;
	static HashMap<String, Double> subIndex;
	static Scanner sc;
	public Date date;
	public static HashMap<Integer, Integer> _pm10, _pm2dot5, _no2, _o3, _so2, _nh3;
	public static HashMap<Integer, Double> _co, _pb;
	static double AQI;
	static int flag = 0;

	public String calculate(Pollutant emp, ModelMap model) {
		_pm10 = new HashMap<>();
		_pm10.put(0, 0);
		_pm10.put(50, 50);
		_pm10.put(51, 51);
		_pm10.put(100, 100);
		_pm10.put(101, 101);
		_pm10.put(200, 250);
		_pm10.put(201, 251);
		_pm10.put(300, 350);
		_pm10.put(301, 351);
		_pm10.put(400, 430);
		_pm2dot5 = new HashMap<>();
		_pm2dot5.put(0, 0);
		_pm2dot5.put(50, 30);
		_pm2dot5.put(51, 31);
		_pm2dot5.put(100, 60);
		_pm2dot5.put(101, 61);
		_pm2dot5.put(200, 90);
		_pm2dot5.put(201, 91);
		_pm2dot5.put(300, 120);
		_pm2dot5.put(301, 121);
		_pm2dot5.put(400, 250);
		_no2 = new HashMap<>();
		_no2.put(0, 0);
		_no2.put(50, 40);
		_no2.put(51, 41);
		_no2.put(100, 80);
		_no2.put(101, 81);
		_no2.put(200, 180);
		_no2.put(201, 181);
		_no2.put(300, 280);
		_no2.put(301, 281);
		_no2.put(400, 400);
		_o3 = new HashMap<>();
		_o3.put(0, 0);
		_o3.put(50, 50);
		_o3.put(51, 51);
		_o3.put(100, 100);
		_o3.put(101, 101);
		_o3.put(200, 168);
		_o3.put(201, 169);
		_o3.put(300, 208);
		_o3.put(301, 209);
		_o3.put(400, 748);
		_co = new HashMap<>();
		_co.put(0, 0.0);
		_co.put(50, 1.0);
		_co.put(51, 1.1);
		_co.put(100, 2.0);
		_co.put(101, 2.1);
		_co.put(200, 10.0);
		_co.put(201, 10.0);
		_co.put(300, 17.0);
		_co.put(301, 17.0);
		_co.put(400, 34.0);
		_so2 = new HashMap<>();
		_so2.put(0, 0);
		_so2.put(50, 40);
		_so2.put(51, 41);
		_so2.put(100, 80);
		_so2.put(101, 81);
		_so2.put(200, 380);
		_so2.put(201, 381);
		_so2.put(300, 800);
		_so2.put(301, 801);
		_so2.put(400, 1600);
		_nh3 = new HashMap<>();
		_nh3.put(0, 0);
		_nh3.put(50, 200);
		_nh3.put(51, 201);
		_nh3.put(100, 400);
		_nh3.put(101, 401);
		_nh3.put(200, 800);
		_nh3.put(201, 801);
		_nh3.put(300, 1200);
		_nh3.put(301, 1200);
		_nh3.put(400, 1800);
		_pb = new HashMap<>();
		_pb.put(0, 0.0);
		_pb.put(50, 0.5);
		_pb.put(51, 0.5);
		_pb.put(100, 1.0);
		_pb.put(101, 1.1);
		_pb.put(200, 2.0);
		_pb.put(201, 2.1);
		_pb.put(300, 3.0);
		_pb.put(301, 3.1);
		_pb.put(400, 3.5);
		// log.info("Calling function for applying input.");
		state = emp.getState();
		city = emp.getCity();
		location = emp.getLocation();
		date = Date.valueOf(LocalDate.now());
		// System.out.println(date);
		takeInput(emp);
		if (flag == 0) {
			try {
				// log.info("Calling function for calulating AQI");
				indexCalculation();
			} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			AQI = 450;
		}
		model.addAttribute("state", state);
		model.addAttribute("city", city);
		model.addAttribute("location", location);
		model.addAttribute("pm10", pm10);
		model.addAttribute("pm2dot5", pm2dot5);
		model.addAttribute("no2", no2);
		model.addAttribute("o3", o3);
		model.addAttribute("co", co);
		model.addAttribute("so2", so2);
		model.addAttribute("nh3", nh3);
		model.addAttribute("pb", pb);
		System.out.println(pm10 + " " + pm2dot5 + " " + no2 + " " + o3 + " " + co + " " + " " + so2 + " " + nh3 + " "
				+ pb + "AQI: " + AQI);
		return "Datadisplay";
	}

	static void takeInput(Pollutant emp) {
		// log.info("Applying Input...");
		concentration = new HashMap<>();
		pm10 = emp.getpm10();
		if (pm10 > 430) {
			flag = 1;
		}
		concentration.put("pm10", pm10);
		pm2dot5 = emp.getpm2dot5();
		if (pm2dot5 > 250) {
			flag = 1;
		}
		concentration.put("pm2dot5", pm2dot5);
		no2 = emp.getno2();
		if (no2 > 400) {
			flag = 1;
		}
		concentration.put("no2", no2);
		o3 = emp.geto3();
		if (o3 > 748) {
			flag = 1;
		}
		concentration.put("o3", o3);
		co = emp.getco();
		if (co > 34) {
			flag = 1;
		}
		concentration.put("co", co);
		so2 = emp.getso2();
		if (so2 > 1600) {
			flag = 1;
		}
		concentration.put("so2", so2);
		nh3 = emp.getnh3();
		if (nh3 > 1800) {
			flag = 1;
		}
		concentration.put("nh3", nh3);
		pb = emp.getpb();
		if (pb > 3.5) {
			flag = 1;
		}
		concentration.put("pb", pb);
	}

	static void indexCalculation()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		subIndex = new HashMap<>();
		Iterator<String> gases = concentration.keySet().iterator();
		while (gases.hasNext()) {
			String gas = gases.next();
			double value = concentration.get(gas);
			String str = "_" + gas;// this will create string instance like
									// _so2,_nh3 etc..
			Class obj = AQICalculation.class;
			Field field = obj.getField(str);
			Class<?> type = field.getType();
			if (type == HashMap.class) {
				if (!(str.equals("_co") || str.equals("_pb"))) {
					HashMap<Integer, Integer> map = (HashMap<Integer, Integer>) field.get(AQICalculation.class);
					Iterator<Integer> itr = map.keySet().iterator();
					double min = 0.0, max = 400, temp, bhi = 0.0, blo = 0.0;
					int temp1;
					while (itr.hasNext()) {
						temp1 = itr.next();
						temp = map.get(temp1);
						if (temp < value && temp > min) {
							min = temp;
							blo = temp1;
						}
						if (temp > value && temp < max) {
							max = temp;
							bhi = temp1;
						}
					}
					double ih, il, bh, bl;
					ih = bhi;
					il = blo;
					bh = max;
					bl = min;
					double aqi = ((ih - il) / (bh - bl) * (value - bl)) + il;
					subIndex.put(gas, aqi);
				} else {
					HashMap<Integer, Double> map = (HashMap<Integer, Double>) field.get(AQICalculation.class);
					Iterator<Integer> itr = map.keySet().iterator();
					double min = 0.0, max = 400, temp, bhi = 0.0, blo = 0.0;
					int temp1;
					while (itr.hasNext()) {
						temp1 = itr.next();
						// System.out.println(temp1);
						temp = map.get(temp1);
						if (temp < value && temp > min) {
							min = temp;
							blo = temp1;
						}
						if (temp > value && temp < max) {
							max = temp;
							bhi = temp1;
						}
					}
					double ih, il, bh, bl;
					ih = bhi;
					il = blo;
					bh = max;
					bl = min;
					double aqi = ((ih - il) / (bh - bl) * (value - bl)) + il;
					subIndex.put(gas, aqi);
				}

			}
		}
		Iterator<Double> subIndexIterator = subIndex.values().iterator();
		AQI = 0.0;
		while (subIndexIterator.hasNext()) {
			double temp2 = subIndexIterator.next();
			if (temp2 > AQI)
				AQI = temp2;
		}
	}

	public void databaseCall() {
		// log.info("Inside Database Testing...");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		Testing testing = (Testing) context.getBean("testing");
		testing.feedDatabse(state, city, location, date, pm10, pm2dot5, no2, o3, co, so2, nh3, pb, AQI);
	}
}
