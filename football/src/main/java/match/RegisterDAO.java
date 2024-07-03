package match;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterDAO {
	 Connection con;
     PreparedStatement pst;
     ResultSet rs;
     
     
     public RegisterDAO() {
     	try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/register" , "root", "12345");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
     	
     }
     
     public void storeData(Register r) {
     	String sql = "insert into matches values(?,?,?) ";

     	try {
				pst = con.prepareStatement(sql);
				pst.setString(1,r.getName());
				pst.setString(2, r.getPlace());
				pst.setString(3, r.getDt());
				pst.executeUpdate();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
     }
}
