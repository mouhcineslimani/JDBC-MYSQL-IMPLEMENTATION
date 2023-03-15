package org.mql.mysql.jdbc;

public class MySQLDataSource extends DataSource {

	// 1. les variables driver et bridge
	public static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
	public static final String MYSQL_BRIDGE = "jdbc:mysql:";

	public MySQLDataSource(String host, String source, String user, String password) {
		super(MYSQL_DRIVER, MYSQL_BRIDGE, host, source, user, password);
	}

	public MySQLDataSource(String source, String user, String password) {
		super(MYSQL_DRIVER, MYSQL_BRIDGE, "localhost", source, user, password);
	}

	public MySQLDataSource(String user, String password) {
		super(MYSQL_DRIVER, MYSQL_BRIDGE, "localhost", "mysql", user, password);
	}

	public MySQLDataSource(String source) {
		super(MYSQL_DRIVER, MYSQL_BRIDGE, "localhost", source, "root", "");
	}

	public MySQLDataSource() {
		super(MYSQL_DRIVER, MYSQL_BRIDGE, "localhost", "mysql", "root", "");
	}

}
