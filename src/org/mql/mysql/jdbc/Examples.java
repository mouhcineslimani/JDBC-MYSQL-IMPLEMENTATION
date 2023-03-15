package org.mql.mysql.jdbc;

public class Examples {

	public Examples() {
		exp01();
	}
	
	void exp01() {
		// faire pour sql server et oracle 
		DataSource ds = new MySQLDataSource("Biblio");
		DataBase db = new DataBase(ds) ; 
		//db.select("Authors");
		String data [][] = db.select("Authors","Author","Floyd");
		for (int row = 0; row < data.length; row++) {
			for (int col = 0; col < data[row].length; col++) {
				System.out.print(data[row][col]+"\t\t");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		new Examples();
	}

}
