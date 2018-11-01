package Login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EnterCityCountry
 */
@WebServlet("/EnterCityCountry")
public class EnterCityCountry extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public EnterCityCountry() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.getSession().setAttribute("First Name", request.getParameter("First Name"));
		request.getSession().setAttribute("Last Name", request.getParameter("Last Name"));
		
		String url = response.encodeURL("EnterEmailPhone");
		
		
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<form method='POST' action ='" + url + "'>");
		out.print("City: ");
		out.print("<Input type = 'text' name = 'City'/><br>");
		out.print("Country: ");
		out.print("<Input type = 'text' name = 'Country'/><br>");
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
