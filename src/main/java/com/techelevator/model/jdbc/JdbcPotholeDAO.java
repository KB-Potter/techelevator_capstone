package com.techelevator.model.jdbc;

import com.techelevator.model.Pothole;
import com.techelevator.model.PotholeDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

@Component
public class JdbcPotholeDAO implements PotholeDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcPotholeDAO(DataSource dataSource) {
    		this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Pothole> getListOfPotholesOrderByDate() {
    		List<Pothole> potholeList = new ArrayList<Pothole>();
		String getAllPotholes = "SELECT * FROM pothole ORDER BY report_date";
		Pothole thePothole;
		SqlRowSet results = jdbcTemplate.queryForRowSet(getAllPotholes);
		while (results.next()) {
			thePothole = mapRowToPothole(results);
			potholeList.add(thePothole);
		}
		return potholeList;
    }
    
    @Override
	public List<Pothole> getListOfPotholesOrderBySeverity() {
	    	List<Pothole> potholeList = new ArrayList<Pothole>();
			String getAllPotholes = "SELECT * FROM pothole ORDER BY severity";
			Pothole thePothole;
			SqlRowSet results = jdbcTemplate.queryForRowSet(getAllPotholes);
			while (results.next()) {
				thePothole = mapRowToPothole(results);
				potholeList.add(thePothole);
			}
			return potholeList;
	}

	@Override
	public List<Pothole> getListOfPotholesOrderByStreetName() {
		List<Pothole> potholeList = new ArrayList<Pothole>();
		String getAllPotholes = "SELECT * FROM pothole ORDER BY street_name";
		Pothole thePothole;
		SqlRowSet results = jdbcTemplate.queryForRowSet(getAllPotholes);
		while (results.next()) {
			thePothole = mapRowToPothole(results);
			potholeList.add(thePothole);
		}
		return potholeList;
	}

	@Override
	public List<Pothole> getListOfPotholesOrderByStatusCode() {
		List<Pothole> potholeList = new ArrayList<Pothole>();
		String getAllPotholes = "SELECT * FROM pothole ORDER BY status_code";
		Pothole thePothole;
		SqlRowSet results = jdbcTemplate.queryForRowSet(getAllPotholes);
		while (results.next()) {
			thePothole = mapRowToPothole(results);
			potholeList.add(thePothole);
		}
		return potholeList;
	}
    
    private Pothole mapRowToPothole(SqlRowSet results) {
        Pothole thePothole = new Pothole();
        thePothole.setStreetName(results.getString("street_name"));
        thePothole.setStatusCode(results.getString("status_code"));
        thePothole.setStatusDate(results.getDate("status_date").toLocalDate());
        thePothole.setSeverity(results.getInt("severity"));
        thePothole.setLongitude(results.getDouble("longitude"));
        thePothole.setLatitude(results.getDouble("latitude"));
        thePothole.setReportDate(results.getDate("report_date").toLocalDate());
        return thePothole;
    }

	
}
