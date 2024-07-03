package match;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Viewmatch")
public class Viewmatch extends HttpServlet {
    private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MatchDAO MatchDAO = new MatchDAO();
        List<Match> matchList = MatchDAO.getAllMatches();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Match Details</title></head>");
        out.println("<body>");
        out.println("<h2>Match Details</h2>");
        out.println("<table border='1'>");
        out.println("<tr><th>Title</th><th>Place</th><th>Date</th></tr>");

        for (Match match : matchList) {
            out.println("<tr>");
            out.println("<td>" + match.getTitle() + "</td>");
            out.println("<td>" + match.getPlace() + "</td>");
            out.println("<td>" + match.getDt() + "</td>");
            out.println("</tr>");
        }

        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}