package com.Servlets.helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;



public class Validator {
	
	public static String UserName;

	
	
	static Connection myConn = null;
	static PreparedStatement pstmt = null;
	static ResultSet myRs = null;

	
	public static void getConnection() throws FileNotFoundException, IOException, SQLException {
			Properties props = new Properties();
			props.load(new FileInputStream("/Eclipse/JEE/onlineTransaction/Properties/covidlist.properties"));

			String dburl = props.getProperty("dbURL");
			String user = props.getProperty("user");
			String password = props.getProperty("password");

			myConn = DriverManager.getConnection(dburl, user, password);

			System.out.println("\n\nConnection to Database Successful");
		}
	
	
	public static boolean isValid(String username, String password) throws SQLException {
		boolean result = false;
		String real_pass = null;
		
		pstmt = myConn.prepareStatement("SELECT password FROM online_banker WHERE user_name = ?");
		pstmt.setString(1, username);
		myRs = pstmt.executeQuery();
		
		
		while(myRs.next()) {
			real_pass = myRs.getString("password");	
		}
		
		if(password.equals(real_pass)) {
			result = true;
		}else {
			result = false;
		}
		
		return result;
	}
	
	public static double getBalance(String username) throws SQLException {
		
		double balance = 0.0;
		pstmt = myConn.prepareStatement("SELECT account_balance FROM online_banker ob INNER JOIN bank_users_details bud ON  ob.account_id = bud.bank_user_id WHERE ob.user_name = ?;");
		pstmt.setString(1, username);
		myRs  = pstmt.executeQuery();
		
		while(myRs.next()) {
			balance = myRs.getDouble("account_balance");
		}
		
		return balance;
	}


	public static void dbClosing() {
		try {
			if(myConn!= null) myConn.close();
			if(pstmt != null) pstmt.close();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}


	public static boolean TransferMoney(String senderName, String receiverName, double amount) throws SQLException {
		boolean result  = false;
		String reason = null;
		String status = "Failed";
		double senderBalance = Validator.getBalance(senderName);
		double receiverBalance = Validator.getBalance(receiverName);
		
		
		if(senderBalance < amount) {
			reason = "Insufficient Balance";
			System.out.println("Insufficient Balance");
			UpdateTransaction(senderName,receiverName,amount,status,reason);
			
		}else {
			senderBalance = senderBalance - amount;
			receiverBalance = receiverBalance + amount;
			UpdateDatabase(senderName,senderBalance);
			UpdateDatabase(receiverName,receiverBalance);
			status = "Successful";
			UpdateTransaction(senderName,receiverName,amount,status,reason);
			
			result = true;
		}
		
		
		
		
		return result;
	}
	
	private static void UpdateDatabase(String user_name,double user_balance) throws SQLException {
		int user_id = 0;
		pstmt = myConn.prepareStatement("SELECT account_id FROM online_banker WHERE user_name =?");
		pstmt.setString(1,user_name);
		myRs = pstmt.executeQuery();
		
		while(myRs.next()) {
			user_id = myRs.getInt("account_id");
		}
		
		pstmt = myConn.prepareStatement("UPDATE bank_users_details SET account_balance = ? WHERE bank_user_id = ?");
		pstmt.setDouble(1, user_balance);
		pstmt.setInt(2, user_id);
		
		int rowsAffected = pstmt.executeUpdate();
		
		if(rowsAffected == 1) System.out.println("Update Successful");
		else System.out.println("Update Failed");
	

	}
	
	private static void UpdateTransaction(String senderName, String receiverName, double amount, String status, String reason) throws SQLException {
		pstmt = myConn.prepareStatement("INSERT INTO transaction(from_user,to_user,amount,status,reason) VALUES (?,?,?,?,?);");
		pstmt.setString(1, senderName);
		pstmt.setString(2, receiverName);
		pstmt.setDouble(3, amount);
		pstmt.setString(4, status);
		pstmt.setString(5, reason);
		int rowsAffected = pstmt.executeUpdate();
		if(rowsAffected == 1) System.out.println("Transaction Update Successful");
		else System.out.println("Transaction Update Failed");
	}
	
	
		
	}




