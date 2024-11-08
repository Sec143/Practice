package com.project.DataBase;

import java.sql.*;
import java.util.Scanner;

public class JdbcConnection {

	public static void main(String args[]) {
		try {
			int id = 0;
			String name = "";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Sample", "root", "root");
		
			Statement stmt = con.createStatement();
			ResultSet rs1 = stmt.executeQuery("select * from STUDENT");
			while (rs1.next()) {
				System.out.println(rs1.getInt(1) + "  " + rs1.getString(2) + "  " + rs1.getString(3));
			System.out.println("entered");
			id =rs1.getInt(1);
			name =rs1.getString(2);
			}
			
          Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Sample2", "root", "root");
			
			//Statement stmt2 = con2.prepareStatement("insert into STUDENT2  values(stdid,stdname) (id, name)");
//			(stdid,stdname)
			/*Statement stmt2 = con2.prepareStatement("INSERT INTO STUDENT2  (stdid, stdname)"
					" VALUES "	+ "(" +id + ", '" + name + "',  + ")";);
//			*/
			PreparedStatement stmt2 = con2.prepareStatement("INSERT INTO STUDENT2 (stdid, stdname) VALUES (?,?)");
			stmt2.setInt(1, id);
			stmt2.setString(2, name);
			stmt2.executeUpdate();
			
			
			
			String[] tables = {"authors", "authors1", "authors2", "authors3","authors4", "authors5", "authors6", "authors7","emp","persons","student"};
			for (int i = 0; i < tables.length; i++) {
			  System.out.println(tables[i]);
			}
		//	select * into databaseto.dbo.emp from databasefrm.dbo.Emp;
     	//System.out.println(rs2.getInt(1) + "  " + rs2.getString(2) + "  " + rs2.getString(3));
				
					//stmt2.executeQuery("select stdid,stdname,fee from STUDENT2");
			con.close();
			con2.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
