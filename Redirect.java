package Login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Redirect
 */
@WebServlet("/Redirect")
public class Redirect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Redirect() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		Map<String, User> map = (HashMap<String, User>) this.getServletContext().getAttribute("Map");
		String email = request.getParameter("Email").toString();

		// map will be created at login page if its not existent so no need to worry
		// about null
		// check if email is in map, or if so, whether password matches
		RequestDispatcher rd;
		if (map.containsKey(email)) {
			if (request.getParameter("Password").equals(map.get(email).getPassword())) {
				User user = map.get(email);
				request.getSession().setAttribute("First Name", user.getFirst_name());
				request.getSession().setAttribute("Last Name", user.getLast_name());
				request.getSession().setAttribute("City", user.getCity());
				request.getSession().setAttribute("Country", user.getCountry());
				request.getSession().setAttribute("Email", user.getEmail());
				rd = request.getRequestDispatcher("SummaryPage");
				rd.forward(request, response);
				
			} else {
				rd = request.getRequestDispatcher("ErrorPage");
				rd.forward(request, response);
			}
		} else {
			rd = request.getRequestDispatcher("ErrorPage");
			rd.forward(request, response);
			
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
