package com.xworkz.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.xworkz.jdbcdemo.dto.MovieDAO;

public class Runner {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		
//		insertmovie();
//		updatemovie();
//		deleteMovie();
		MovieDAO dao=new MovieDAO();
//		dao.getNameByMovieId();
//		dao.getAll();
		System.out.println("enter movie name to get language and budget");
		String name1=sc.nextLine();
		dao.getLanguageAndBudgetByName(name1);
		
	}

	private static void insertmovie() {
		Statement statement = null;
		Connection connection = null;
		
		Scanner sc1 = new Scanner(System.in);
		
		System.out.println("Enter the movie name");
		String name = sc1.next();
	
		
		System.out.println("�nter the Language");
		String lang = sc1.next();
		
		System.out.println("Enter the budget");
		long budget = sc1.nextLong();
		
		System.out.println("Enter the rating");
		int rate = sc1.nextInt();
		
		System.out.println("Enter the id");
		int id = sc1.nextInt();
		//step 1
		// load and register the driver

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("class loaded");
			
			//step 2
			// create connection (Establish connection with mysql server)
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jan06","root","root");
			System.out.println("Connection created");
			
			//step 3
			//create a platform/environment to execute the queries
			statement = connection.createStatement();
			System.out.println("Statement created");
			
			//step 4
			//execute the query
			statement.execute("Insert into movie values(("+id+"),('"+name+"'),("+rate+"),('"+lang+"'),("+budget+"))");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//step 6
			//close the costly resource
			try {
				if(statement!=null)
					statement.close();
				if(connection!=null)
					connection.close();
				
			} catch(Exception e2) {
				e2.printStackTrace();
		}
		}
		
		
	}
		
		private static void updatemovie() {
			Statement statement = null;
			Connection connection = null;
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter the movie name to update");
			String name = sc.next();
		
			
			System.out.println("�nter the Language to update");
			String lang = sc.next();
			
			System.out.println("Enter the budget to update");
			long budget = sc.nextLong();
			
			System.out.println("Enter the rating to update");
			int rate = sc.nextInt();
			
			System.out.println("Enter the id to update all details");
			int id = sc.nextInt();
			
			//step 1
			// load and register the driver

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("class loaded");
				
				//step 2
				// create connection (Establish connection with mysql server)
				
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jan06","root","root");
				System.out.println("Connection created");
				
				//step 3
				//create a platform/environment to execute the queries
				statement = connection.createStatement();
				System.out.println("Statement created");
				
				//step 4
				//execute the query
		statement.execute("UPDATE movie SET name=(('"+name+"'),language=('"+lang+"'),budget=("+budget+"),rating=("+rate+")where id =("+id+")");	
		System.out.println("movie updated");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				//step 6
				//close the costly resource
				try {
					if(statement!=null)
						statement.close();
					if(connection!=null)
						connection.close();
					
				} catch(Exception e2) {
					e2.printStackTrace();
			}
			}
			}
	
			private static void deleteMovie() {
				Scanner sc2=new Scanner(System.in);
			
				System.out.println("enter id to delete all");
				int id=sc2  .nextInt();
				
				Connection connection=null;
				Statement statement=null;
				try {
					connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jan06", "root", "ROOT");
					System.out.println("Connection created");
					
					statement=connection.createStatement();
					System.out.println("statement is created");
					
					statement.execute("DELETE FROM movie where id=("+id+")");
					System.out.println("successfully deleted");
					
				}catch (SQLException e) {
					e.printStackTrace();
				}
				finally {
					//step 6 
					//close the costly resources
					try {
						if(statement !=null )
							statement.close();
						if(connection != null)
							connection.close();
							
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
		
			}
		
		
  }

