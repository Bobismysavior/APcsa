package application;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;



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
		String query = "";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
		}catch(Exception e){
			e.printStackTrace();
			return e.toString();		}
	}
	
	
}
