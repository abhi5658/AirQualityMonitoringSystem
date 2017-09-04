package com.tcs.aqi.database;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tcs.aqi.beans.NotificationDetail;

public class citymapper implements RowMapper<NotificationDetail> {

	@Override
	public NotificationDetail mapRow(ResultSet rs, int arg1) throws SQLException {
		System.out.println("inside citymapper");
		NotificationDetail nd = new NotificationDetail();
		nd.setCity(rs.getString("city"));
		return nd;
	}

}
