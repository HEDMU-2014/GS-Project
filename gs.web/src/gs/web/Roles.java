package gs.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejb.beans.RoleLocal;

/**
 * Servlet implementation class Roles
 */
@WebServlet("/Roles")
public class Roles extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB private RoleLocal ejb;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Roles() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("<h1>Http-method GET received");
		String greeting = ejb.greeting(request.getParameter("name"));
		response.getWriter().append("<h1>").append(greeting);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("<h1>Http-method POST received");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("<h1>Http-method PUT received");
	}

}
