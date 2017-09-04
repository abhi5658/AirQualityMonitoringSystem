package com.tcs.aqi.database;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.RowMapper;

import com.tcs.aqi.beans.NotificationDetail;

public class NotificationDeatailMapper implements RowMapper<NotificationDetail> {

	@Override
	public NotificationDetail mapRow(ResultSet rs, int arg1) throws SQLException {
		NotificationDetail nd = new NotificationDetail();
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		Testing testing = (Testing) context.getBean("testing");
		while (rs.next()) {
			nd.setDate(rs.getDate("date"));
			nd.setAqi(rs.getDouble("aqi"));
			String state = testing.getstate(rs.getString("stateid"));
			nd.setState(state);
			String city = testing.getcity(rs.getString("cityid"));
			nd.setCity(city);
			String loc = testing.getlocation(rs.getString("locationid"));
			nd.setLocation(loc);
			testing.addNotification(rs.getDate("date"), rs.getDouble("aqi"), state, city, loc);
			System.out.println("Mapping........: [" + rs.getDate("date") + ", " + rs.getDouble("aqi") + ", "
					+ rs.getString("stateid") + ", " + rs.getString("cityid") + ", " + rs.getString("locationid")
					+ "]");
		}
		return nd;
	}

}
