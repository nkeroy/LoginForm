package Login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SummaryPage
 */
@WebServlet("/SummaryPage")
public class SummaryPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SummaryPage() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String first_name = request.getSession().getAttribute("First Name").toString();
		String last_name = request.getSession().getAttribute("Last Name").toString();
		String city = request.getSession().getAttribute("City").toString();
		String country = request.getSession().getAttribute("Country").toString();
		String email = request.getParameter("Email").toString();
		String password = request.getParameter("Password").toString();
		
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<form method = 'POST' action = 'LoginPage'>");
		out.print("<p>First Name: " +first_name + "<br><br>");
		out.print("<p>Last Name: " + last_name + "<br><br>");
		out.print("<p>City: " + city + "<br><br>");
		out.print("<p>Country: " + country + "<br><br>");
		out.print("<p>Email: " + email + "<br><br>");
		
		
		HashMap<String,User> map = (HashMap<String,User>)getServletContext().getAttribute("Map");
		if(!map.containsKey(request.getParameter("Email"))) {
			out.print("<b>Do you wish to confirm?</b>");
			map.put(request.getParameter("Email"), new User(first_name, last_name, city, country, email, password));
			out.print("<input type = 'submit'>");
		}  else {
			//request.getRequestDispatcher("LoginPage");
			out.print("<a href='LoginPage'>back</a>");
		}
		
		out.print("</form>");
		out.print("</body>");
		out.print("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
