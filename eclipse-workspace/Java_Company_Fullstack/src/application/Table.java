package application;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;
import java.util.PreparedStatement;

public abstract class Table {
    private Connection conn;
    private ArrayList<WidgetRecord> results;
    private ResultSet rs;

    
    public Table(ArrayList<WidgetRecord> results, ResultSet rs) {
        this.results = results;
        this.rs = rs;
    }


    public boolean connectDb() {
		try {
			// Class.forName("com.mysql.jdbc.Driver");
			String loadPath = getDbConfigPath();
			FileInputStream inFile = new FileInputStream(loadPath);
			Properties props = new Properties();
			props.load(inFile);
			
			conn = DriverManager.getConnection(props.getProperty("dbUrl"), props.getProperty("dbUser"), null);
			//Internal test  code
			mapDatabase();
		
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
		return true;
	}
		
	public boolean disconnectDb() {
		try {
			conn.close();
		}catch(Exception e){
			System.out.println(e);
			return false;
		}
		return true;
	}

    public Connection getConn() {
        return conn;
    }
    public void setConn(Connection conn) {
        this.conn = conn;
    }
    public ArrayList<WidgetRecord> getResults() {
        return results;
    }
    public void setResults(ArrayList<WidgetRecord> results) {
        this.results = results;
    }
    public ResultSet getRs() {
        return rs;
    }
    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public abstract void mapDatabase();

    protected abstract String getDbConfigPath();

    public abstract WidgetRecord getRowRelated(int id, TableOption table);

    public abstract String addRecord(WidgetRecord w);

    public abstract String loadResults(); 

    public abstract String editRecord(WidgetRecord w);

    public abstract String deleteRecord(WidgetRecord w);

    public abstract int fetchLastId();
}