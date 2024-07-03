package match;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketDAO {
	 Connection con;
     PreparedStatement pst;
     ResultSet rs;
     
     
     public TicketDAO() {
     	try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
     	
     }
     
     public void storeData(Ticket t) {
     	String sql = "insert into ticketbook values(?,?,?,?,?) ";

     	try {
				pst = con.prepareStatement(sql);
				pst.setString(1, t.getName());
				pst.setString(2, t.getMatches());
				pst.setString(3, t.getPlace());
				pst.setString(4, t.getDt());
				pst.setString(5, t.getTicket());
				pst.executeUpdate();
			}
     	    catch (SQLException e) 
     	      {
			
				e.printStackTrace();
			  }
     }


}
