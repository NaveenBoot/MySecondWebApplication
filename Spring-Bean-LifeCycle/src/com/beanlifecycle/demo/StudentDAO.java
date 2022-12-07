/*package com.beanlifecycle.demo;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class StudentDAO {
	
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/naveendb";
	private String userName = "root";
	private String password = "Naveen@050";
	
	public void selectAllRows() throws ClassNotFoundException, SQLException {  //if we execute this method we will get all rows in DB
		
		//load driver
		Class.forName(driver);    //to establish connection with db we need to load the driver first
		
		//get a connection
		Connection con = DriverManager.getConnection(url, userName, password);
		
		//execute query
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM naveendb.stuinfohostel;");  //rs contains all your rows iterate through it
		
		while(rs.next()) {  //as long as i have data in rs while loop should run
			
			int studentId = rs.getInt(1);
			String studentName = rs.getString(2);
			double hostelFee = rs.getDouble(3);
			String foodType = rs.getString(4);
			
			System.out.println(studentId + " " + studentName + " " + hostelFee + " " + foodType );
		}
		//closing the connection
		con.close();
	}
	
	public void deleteRow(int studentId) throws ClassNotFoundException, SQLException {
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, userName, password);
		Statement stmt = con.createStatement();
	    stmt.executeUpdate("delete from naveendb.stuinfohostel where student_id = " + studentId);
		System.out.println("record deleted with" + studentId);
		con.close();
		
	}
	

}*/


package com.beanlifecycle.demo;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import java.sql.Connection;

public class StudentDAO {

	private String driver;
	private String url;
	private String userName;
	private String password;
	Connection con;

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@PostConstruct   //to maintain coding standards we are creating init method
	public void init() throws ClassNotFoundException, SQLException {
		dbConnection();
	}
	
	//@PostConstruct    //spring will call this method after ot created object for StudentDAO class
	public void dbConnection() throws ClassNotFoundException, SQLException {

		// load driver
		Class.forName(driver); // to establish connection with db we need to load the driver first

		// get a connection
		con = DriverManager.getConnection(url, userName, password);
	}

	public void selectAllRows() throws ClassNotFoundException, SQLException { // if we execute this method we will get
																				// all rows in DB
		//dbConnection();
		// execute query
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM naveendb.stuinfohostel;"); // rs contains all your rows iterate
																					// through it

		while (rs.next()) { // as long as i have data in rs while loop should run

			int studentId = rs.getInt(1);
			String studentName = rs.getString(2);
			double hostelFee = rs.getDouble(3);
			String foodType = rs.getString(4);

			System.out.println(studentId + " " + studentName + " " + hostelFee + " " + foodType);
		}

	}

	public void deleteRow(int studentId) throws ClassNotFoundException, SQLException {

		Statement stmt = con.createStatement();
		stmt.executeUpdate("delete from naveendb.stuinfohostel where student_id = " + studentId);
		System.out.println("record deleted with" + studentId);

	}
    
	@PreDestroy
	public void dbClose() throws SQLException {
		System.out.println("in pre destroy method ");
		con.close();
	}

}














