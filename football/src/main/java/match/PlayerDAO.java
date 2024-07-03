package match;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PlayerDAO {
	        Connection con;
	        PreparedStatement pst;
	        ResultSet rs;
	        
	        
	        public PlayerDAO() {
	        	try {
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/player" , "root", "12345");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
	        	
	        }
	        
	        public void storeData(Player p) {
	        	String sql = "insert into members values(?,?) ";

	        	try {
					pst = con.prepareStatement(sql);
					pst.setString(1,p.getName());
					pst.setInt(2, p.getAge());
					pst.executeUpdate();
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
	        }
	}

