package match;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegistermatchCont")
public class RegistermatchCont extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name").trim();
		String place = request.getParameter("place").trim();
		String dt = request.getParameter("dt").trim();
		
		ArrayList<String> list = new ArrayList<String>();
		if(name.length()==0)
			list.add("Enter name field");
		if(place.length()==0)
			list.add("Enter place field");
		
		if(!list.isEmpty()) {
			request.setAttribute("errors" , list);
			RequestDispatcher rd = request.getRequestDispatcher("/Registermatch");
			rd.forward(request, response);
			return;
		}
		
		
		Register r = new Register(name , place , dt);
		RegisterDAO rd = new RegisterDAO();
		rd.storeData(r);
		RequestDispatcher rd1 = request.getRequestDispatcher("Acknowledgement.html");
		rd1.forward(request, response);

	}
	
		// TODO Auto-generated method stub
		
	}


