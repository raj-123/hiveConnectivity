package myHadoop.test;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.hive.jdbc.HiveDriver;


//Hive Server Start
//hive --service hiveserver2 --hiveconf hive.server2.thrift.port=10000 --hiveconf hive.root.logger=INFO,console

public class hiveConnectivity {
	public static String driverName = "org.apache.hive.jdbc.HiveDriver";
	public static void main(String[] args) throws IOException, InterruptedException, SQLException{
		
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Got some exception");
			System.exit(1);
		}
		
		 System.out.println("before connection");
         //Connection con = DriverManager.getConnection("jdbc:hive2://0.0.0.0:10002/default", "", "");
		 Connection con = DriverManager.getConnection("jdbc:hive2://localhost:10000/default", "root", "r123");
         System.out.println("after connection stage");
         Statement stmt = con.createStatement();
         System.out.println("after connection");

         String tableName = "myTable";
         stmt.executeUpdate("CREATE TABLE IF NOT EXISTS " +tableName + "(eid int, name String,salary String, destination String)");
         System.out.println("Table have been created");
        
         String sql = "show tables '" + tableName + "'";
	}

}
