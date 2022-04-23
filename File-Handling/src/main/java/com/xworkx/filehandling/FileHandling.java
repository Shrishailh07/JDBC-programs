package com.xworkx.filehandling;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class FileHandling {


		public static void main(String args[]) throws Exception {
			String query = "INSERT INTO application(application_name) VALUES (?)";

			Connection connection = null;
			PreparedStatement prpstmt = null;

			try {
				connection = DriverManager.getConnection("jdbc:mysql://localhost/jan06", "root", "ROOT");

				System.out.println("Connection established......");

				prpstmt = connection.prepareStatement(query);

				prpstmt.setString(1, "application_name");

				FileReader reader = new FileReader(
						"C:\\Users\\Suresh P K\\Desktop\\JDBC\\FileHandling.txt");
				
				prpstmt.setCharacterStream(1, reader);

				prpstmt.execute();

				System.out.println("Data inserted......");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (prpstmt != null)
						prpstmt.close();
					if (connection != null)
						connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

