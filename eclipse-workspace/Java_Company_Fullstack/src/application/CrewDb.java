/*
 * Kingsley U
 * 26/01/2023
 * APCSA
 */
package application;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class CrewDb {
	private Connection connection;
	private ArrayList<CrewRecord> results;
	private ResultSet rs;
	
	
	public CrewDb() {
		super();
	}


	public Connection getConnection() {
		return connection;
	}


	public void setConnection(Connection connection) {
		this.connection = connection;
	}


	public ArrayList<CrewRecord> getResults() {
		return results;
	}

	public void setResults(ArrayList<CrewRecord> results) {
		this.results = results;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}
	
	//Connection methods
	//***
	public boolean connectToDb() {
		try {
		String loadPath = "src/application/app.properties";
		FileInputStream inputFile = new FileInputStream(loadPath);
		Properties prop = new Properties();
		prop.load(inputFile);
		connection = DriverManager.getConnection(prop.getProperty("dbUrl"),prop.getProperty("dbUser"), prop.getProperty("dbPassword"));
		// test code
		mapDatabase();
		
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean disconnectFromDb() {
		try {
			connection.close();
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		} 
		return true;
	}
	
	//CRUD
	public String addRecord(CrewRecord crew) {
		String query = ""; //Leaving blank until the table structure is fleshed out
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, crew.getPilot());
			preparedStatement.setInt(2, crew.getCopilot());
			preparedStatement.setInt(3, crew.getFa1());
			preparedStatement.setInt(4, crew.getFa2());
			preparedStatement.setString(5, crew.getAirline());
			
			preparedStatement.executeUpdate();
			
			load();
			return "Record added";
		}catch(Exception e){
			e.printStackTrace();
			return e.toString();		}
	}
	
	public String load() {
		try {
			getResults().clear();
			Statement st = connection.createStatement();
			setRs(st.executeQuery("SELECT * FROM ORDER BY Pilot asc"));
			while(getRs().next()) {
				getResults().add(new CrewRecord(rs.getInt(1),rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5)));
				return "Records loaded";
			}
			
			
		} catch(SQLException e) {
			e.printStackTrace();
			return e.toString();
		}
	}
	
	
}
