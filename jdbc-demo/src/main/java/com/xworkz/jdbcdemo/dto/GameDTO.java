import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class GameDTO {
	public boolean saveGame(GameDTO gameDTO)
	{
		String insertQuery = "INSERT into games VALUES(?,?,?,?)";
		if(gameDTO!=null)
		{
			return false;
		}
		else
		{
			Connection connection = null;
		PreparedStatement preparedStatement=null;
		
		try {
			connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)
		}
		}
	}
	

}
