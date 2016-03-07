package gs.web;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gs.ejb.beans.OrganizationLocal;
import gs.ejb.beans.RoleLocal;
import gs.ejb.beans.UserLocal;
import gs.ejb.domain.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB private UserLocal userejb;
	@EJB private RoleLocal roleejb;
	@EJB private OrganizationLocal orgejb;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> users = userejb.searchUsers("EAMV");
		response.getWriter().append("Users : " + users);
//		User user = userejb.getUser(2).get();
//		user.setEmail("fkj@eamv.dk");
//		user.setFirstname("Flemming Koch");
//		user.setLastname("Jensen");
//		user.setRoles(new ArrayList<>());
//		user.getRoles().add(new Role(2, "?"));
//		userejb.createUser(user);
//		Organization org = orgejb.getOrganization(1).get();
//		response.getWriter().append("Org: " + org);
//		Role role = roleejb.getRole(1).get();
//		response.getWriter().append("Role: " + role);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
