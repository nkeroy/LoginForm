package Login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EnterEmailPhone
 */
@WebServlet("/EnterEmailPhone")
public class EnterEmailPhone extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public EnterEmailPhone() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*response.getWriter().append("Served at: ").append(request.getContextPath());*/
		request.getSession().setAttribute("City", request.getParameter("City"));
		request.getSession().setAttribute("Country", request.getParameter("Country"));
		
		String url = response.encodeURL("SummaryPage");
		
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<form method='POST' action ='" + url +"'>");
		out.print("Email: ");
		out.print("<Input type = 'text' name = 'Email'/><br><br>");
		out.print("Password: ");
		out.print("<Input type = 'password' name = 'Password'/><br><br>");
		out.print("<Input type = 'submit'/>");
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
