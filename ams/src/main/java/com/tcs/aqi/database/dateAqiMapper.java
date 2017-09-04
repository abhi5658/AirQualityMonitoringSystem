package com.tcs.aqi.database;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.springframework.jdbc.core.RowMapper;

import com.tcs.aqi.beans.Pollutant;

public class dateAqiMapper implements RowMapper<Pollutant> {

	@Override
	public Pollutant mapRow(ResultSet rs, int a) throws SQLException {
		Pollutant pollutant = new Pollutant();
		while (rs.next()) {
			Date date = rs.getDate("date");
			double aqi = rs.getDouble("aqi");
			pollutant.getDateAqi().put(date, aqi);
			if (date.compareTo(Date.valueOf(LocalDate.now())) == 0) {
				pollutant.setpm10((float) rs.getDouble("pm10"));
				pollutant.setpm2dot5((float) rs.getDouble("pm2dot5"));
				pollutant.setno2((float) rs.getDouble("no2"));
				pollutant.seto3((float) rs.getDouble("o3"));
				pollutant.setco((float) rs.getDouble("co"));
				pollutant.setso2((float) rs.getDouble("so2"));
				pollutant.setnh3((float) rs.getDouble("nh3"));
				pollutant.setpb((float) rs.getDouble("pb"));
			}
		}
		return pollutant;
	}

}
