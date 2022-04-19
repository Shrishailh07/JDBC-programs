package com.xworkz.jdbcdemo.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MovieDAO {
	public void getNameByMovieId() {
		String query="SELECT name FROM movie where id=10";
		Connection connection =null;
		Statement statement = null;
		ResultSet resultSet=null;
		try {
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jan06","root","root");
			statement=connection.createStatement();
			resultSet=statement.executeQuery(query);
			while(resultSet.next()) {
				System.out.println("movie name:"+resultSet.getString("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void getAll() {
		String query="SELECT * FROM movie ";
		Connection connection =null;
		Statement statement = null;
		ResultSet resultSet=null;
		try {
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jan06","root","root");
			statement=connection.createStatement();
			resultSet=statement.executeQuery(query);
			while(resultSet.next()) {
		
				System.out.println("movie id:"+resultSet.getInt("id"));
				System.out.println("movie name:"+resultSet.getString("name"));
				System.out.println("movie lang:"+resultSet.getString("language"));
				System.out.println("movie rating:"+resultSet.getInt("rating"));
				System.out.println("movie budget:"+resultSet.getLong("budget"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void getLanguageAndBudgetByName(String name) {
		
		String query="SELECT language,budget FROM movie where name=('"+name+"') ";
		Connection connection =null;
		Statement statement = null;
		ResultSet resultSet=null;
		
		try {
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jan06","root","root");
			statement=connection.createStatement();
			resultSet=statement.executeQuery(query);
			while(resultSet.next()) {
				System.out.println("movie lang:"+resultSet.getString("language"));
				
				System.out.println("movie budget:"+resultSet.getLong("budget"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	}

