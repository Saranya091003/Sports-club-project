package match;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import match.Match;
import match.MatchDAO;


@WebServlet("/AddmatchCont")
public class AddmatchCont extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title").trim();
		String place = request.getParameter("place").trim();
		String dt = request.getParameter("dt").trim();
		
		ArrayList<String> list = new ArrayList<String>();
		if(title.length()==0)
			list.add("Enter title field");
		if(place.length()==0)
			list.add("Enter place field");
		
		if(!list.isEmpty()) {
			request.setAttribute("errors" , list);
			RequestDispatcher rd = request.getRequestDispatcher("/Addmatch");
			rd.forward(request, response);
			return;
		}
		
		
		Match m = new Match(title , place , dt);
		MatchDAO md = new MatchDAO();
		md.storeData(m);
		RequestDispatcher rd1 = request.getRequestDispatcher("Acknowledgement.html");
		rd1.forward(request, response);

	}

}