package org.mql.mysql.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataSource {

	// 1. déclaration des 6 variables 
	private String driver ; 
	private String bridge ; 
	private String host ; 
	private String source ; 
	private	String user ; 
	private String password ;
	// 2. constructeur avec parametres 
	public DataSource(String driver, String bridge, String host, String source, String user, String password) {
		super();
		this.driver = driver;
		this.bridge = bridge;
		this.host = host;
		this.source = source;
		this.user = user;
		this.password = password;
	} 
	// 3. getters et setters 
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getBridge() {
		return bridge;
	}
	public void setBridge(String bridge) {
		this.bridge = bridge;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	//4. getConnection method : Connection Interface to maintain the abstraction
	public Connection getConnection()
	{
		try {
			// 1. charger le driver 
			Class.forName(driver);
			// 2. composer l'url 
			String url = bridge+"//"+host+"/"+source ; 
			// 3. connexion
			Connection db = DriverManager.getConnection(url,user,password);
			System.out.println("La connexion est bien établie !!");
			return db ; 
		} catch (Exception e) { 
			return null ; 
		}
		
	}
	
	
	
	
	
	
	
	
}
