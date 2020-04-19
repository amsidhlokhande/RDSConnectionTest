package com.amsidh.mvc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainApp {

	public static void main(String[] args) {
		Connection con = null;
		try {

			Class.forName("org.postgresql.Driver");

			con = DriverManager.getConnection(
					"jdbc:postgresql://mypostgres.ckdxuotg29id.ap-south-1.rds.amazonaws.com:5432/postgresdb",
					"postgres", "postgres");
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from employee");
			while (resultSet.next()) {
				System.out.println(resultSet.getInt("id") + " : " + resultSet.getString("name"));
			}

			/*
			 * int executeUpdate =
			 * statement.executeUpdate("INSERT INTO EMPLOYEE (ID,NAME) VALUES (3,'ADITYA')"
			 * ); System.out.println(executeUpdate);
			 */
			statement.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception ex1) {
				ex1.printStackTrace();
			}
		}

	}

}
