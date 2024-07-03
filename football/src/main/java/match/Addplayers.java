package match;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Addplayers")

public class Addplayers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletConfig cnf=getServletConfig();
		String num=cnf.getInitParameter("num");
		ServletContext ctx=getServletContext();
		String str=ctx.getInitParameter("driver");
		PrintWriter out =response.getWriter();
		response.setContentType("text/html");
		ArrayList list = (ArrayList)
		request.getAttribute("errors");
		if (list != null) {
            Iterator itr = list.iterator();
            out.println("<ul>");
            while (itr.hasNext()) {
                out.println("<li>" + itr.next() + "</li>");
            }
            out.println("</ul>");
        } else {
            out.println("<ul><li>No errors found</li></ul>");
        }
		out.println("<html>");
		out.println("<body>");
		out.println("</ul>");
		out.println("<center><h2> Add Players Details </h2>");
		out.println("<form action='AddplayersCont'  method='post' >");
		out.println("Player Name <input type='text' name='name' > <br><br> ");
		out.println("Player Age <input type='text' name='age' > <br><br> ");
		out.println("<input type='submit' value='Submit' > ");
		out.println("</form></center> </body> </html> ");

		}

}
