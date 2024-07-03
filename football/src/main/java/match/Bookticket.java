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


@WebServlet("/Bookticket")
public class Bookticket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletConfig cnf=getServletConfig();
		String num=cnf.getInitParameter("num");
		ServletContext ctx=getServletContext();
		String str=ctx.getInitParameter("driver");
		PrintWriter out =response.getWriter();
		response.setContentType("text/html");
		ArrayList<String> list = (ArrayList<String>)request.getAttribute("errors");
		if (list != null) {
            Iterator<String> itr = list.iterator();
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
		out.println("<center><h2> Ticket Booking </h2>");
		out.println("<form action='BookticketCont'  method='post' >");
		out.println("Name :<input type='text' name='name' > <br><br> ");
		out.println("Name of the Match :<input type='text' name='matches' > <br><br> ");
		out.println("Match Date :<input type='datetime' name='dt' > <br><br> ");
		out.println("Place :<input type='text' name='place' > <br><br> ");
		out.println("Ticket class :<input type='text' name='ticket' > <br><br> ");
		out.println("<input type='submit' value='Register'>");
		out.println("</form></center> </body> </html> ");
		
	}

	}

	


