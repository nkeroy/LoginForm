package Login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginPage
 */
@WebServlet("/LoginPage")
public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginPage() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//insert arraylist inside servletcontext object at start of application which is this page
		if (this.getServletContext().getAttribute("Map") == null) {
			this.getServletContext().setAttribute("Map", new HashMap<String, User>());
		}
		
		
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<form method='POST' action ='Redirect'>");
		out.print("Email: ");
		out.print("<Input type = 'text' name = 'Email'><br><br>");
		out.print("Password: ");
		out.print("<Input type = 'password' name = 'Password'><br><br>");
		out.print("<Input type = 'submit'/><br><br>");
		
		out.print("<a href='EnterFirstLastName'>New User</a>" );
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
