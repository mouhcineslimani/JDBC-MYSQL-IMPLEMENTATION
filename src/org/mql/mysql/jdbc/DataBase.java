package org.mql.mysql.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {

	private Connection db;
	private DataSource dataSource;

	public DataBase(DataSource dataSource) {
		setDataSource(dataSource);
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.db = dataSource.getConnection();
	}

	public String[][] executeQuery(String query) {
		try {
			Statement sql = db.createStatement();
			ResultSet rs = sql.executeQuery(query);
			rs.last(); // aller au dernier element pour determiner le nombre de lignes retournees
			int rows = rs.getRow();
			ResultSetMetaData rsm = rs.getMetaData(); // pour obtenir le nbre de colonnes retournees
			int cols = rsm.getColumnCount();
			String[][] data = new String[rows + 1][cols]; // rows+1 : pour stocker aussi les noms des colonnes à i = 0
			for (int i = 0; i < cols; i++) {
				data[0][i] = rsm.getColumnName(i + 1); // car les colonnes commencent en 1
			}

			rs.beforeFirst();
			int row = 0;
			while (rs.next()) {
				row++;
				for (int i = 0; i < cols; i++) {
					data[row][i] = rs.getString(i + 1);
				}
			}
			rs.close();
			return data;
		} catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
			return null;
		}

	}

	public String[][] select(String tableName) {
		return executeQuery("SELECT * FROM "+tableName);
	}

	public String[][] select(String tableName, String columnName, String keyWord) {
		return executeQuery("SELECT * FROM "+tableName+" WHERE "+columnName+" LIKE '%"+keyWord+"%'");
	}

}
