import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;



public class SQLdriver3  {
Connection con = null;

public static Connection dbConnector()
{
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/costumer_list?autoReconnect=true&useSSL=false", "root", "Jesusaann12");
		return con;
	} catch (Exception exc) {
				JOptionPane.showMessageDialog(null, exc);
				return null;
		}
	
		
		}

	
	


}
		
