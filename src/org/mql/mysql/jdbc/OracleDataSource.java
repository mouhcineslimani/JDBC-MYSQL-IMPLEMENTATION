package org.mql.mysql.jdbc;

public class OracleDataSource extends DataSource {

	public static final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String ORACLE_BRIDGE = "jdbc:oracle:thin:";

	public OracleDataSource(String host, String source, String user, String password) {
		super(ORACLE_DRIVER, ORACLE_BRIDGE, host, source, user, password);
	}

}
