package match;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddplayersCont")
public class AddplayersCont extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name").trim();
		String a=request.getParameter("age").trim();
		int age=0;
		age=Integer.parseInt(a);

		
		List li = new ArrayList();
		if(name.length()==0)
			li.add("Enter name field");
		if(age<18)
			li.add("you are not eligible");
		
		if(!li.isEmpty()) {
			request.setAttribute("errors" , li);
			RequestDispatcher rd = request.getRequestDispatcher("/Addplayers");
			rd.forward(request, response);
			return;
		}
		
		
		Player p = new Player(name , age);
		PlayerDAO pd = new PlayerDAO();
		pd.storeData(p);
		RequestDispatcher rd2 = request.getRequestDispatcher("Acknowledgement");
		rd2.forward(request, response);

	}

}