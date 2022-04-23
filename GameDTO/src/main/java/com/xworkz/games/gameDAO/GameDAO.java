package com.xworkz.games.gameDAO;
import com.xworkz.games.gameDTO.GameDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import static com.xworkz.games.constant.DBCConstatnts.*;
public class GameDAO 
{
	public static Connection getConnection() throws Exception {
	    String driver = "com.mysql.jdbc.Driver";
	    String url = "jdbc:mysql://localhost:3306/jan06";
	    String username = "root";
	    String password = "ROOT";
	    
	    Connection conn = DriverManager.getConnection(url, username, password);
		return conn;
	    
	}
			public static boolean saveGame(GameDTO gameDTO)
			{
				if(gameDTO==null)
				{
					return false;
				}
				else
				{
					Connection connection = null;
				PreparedStatement preparedStatement=null;
				
				try {
					connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				preparedStatement = connection.prepareStatement("INSERT INTO games VALUES(?,?,?,?)");
				
				preparedStatement.setInt(1,gameDTO.getGameId());
				preparedStatement.setString(2,gameDTO.getGameName());
				preparedStatement.setInt(3, gameDTO.getNoOfPlayers());
				preparedStatement.setString(4,gameDTO.getType());
				
				preparedStatement.execute();
				return true;
				
				}catch (Exception e) {
					e.printStackTrace();
				
				}finally {
					try {
				
					if(preparedStatement!=null)
					preparedStatement.close();
					if(connection!=null)
						connection.close();
					}catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					
				}
				
			}
			return false;
     }
   }
				

		


