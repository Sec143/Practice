package com.project.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class DataExport {

	public static void main(String args[]) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Sample", "root", "root");

			Statement stmt = con.createStatement();

			Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Sample2", "root", "root");

			PreparedStatement stmt2 = con2.prepareStatement("INSERT INTO STUDENT2 (stdid, stdname) VALUES (?,?)");
			String[] tables = { "authors", "authors1", "authors2", "authors3", "authors4", "authors5", "authors6",
					"authors7", "emp", "persons", "student" };
			for (int i = 0; i < tables.length; i++) {
				System.out.println(tables[i]);
			}

			con.close();
			con2.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
