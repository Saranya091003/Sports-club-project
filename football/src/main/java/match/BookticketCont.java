package match;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BookticketCont")
public class BookticketCont extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name").trim();
		String matches=request.getParameter("matches").trim();
		String place = request.getParameter("place").trim();
		String dt = request.getParameter("dt").trim();
		String ticket=request.getParameter("ticket").trim();
		
		ArrayList<String> list = new ArrayList<String>();
		if(name.length()==0)
			list.add("Enter name field");
		if(matches.length()==0)
			list.add("Enter match name");
		if(place.length()==0)
			list.add("Enter place field");
		if(ticket.length()==0)
		    list.add("Enter class field");
		if(!list.isEmpty()) {
			request.setAttribute("errors" , list);
			RequestDispatcher rd = request.getRequestDispatcher("/Bookticket");
			rd.forward(request, response);
			return;
		}
		
		
		Ticket t = new Ticket(name , matches, dt,place,ticket);
		TicketDAO td = new TicketDAO();
		td.storeData(t);
		RequestDispatcher rd1 = request.getRequestDispatcher("Acknowledgement.html");
		rd1.forward(request, response);

	}
	
	

}
