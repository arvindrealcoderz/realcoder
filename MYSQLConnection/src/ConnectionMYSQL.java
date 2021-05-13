import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMYSQL {
	public static void main(String[] args) {
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/realcoderz","root","root");
			System.out.println(con);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
