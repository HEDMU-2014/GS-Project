package gs.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.OrganizationBeanLocal;
import beans.RolesBeanLocal;
import beans.UserProfilesBeanLocal;
import beans.UsersBeanLocal;
import domain.Role;
import domain.User;
import domain.UserProfile;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB private UsersBeanLocal userejb;
	@EJB private RolesBeanLocal roleejb;
	@EJB private OrganizationBeanLocal orgejb;
	@EJB private UserProfilesBeanLocal profejb;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> users = userejb.listMembers("eamv");
		response.getWriter().append("Users : " + users);
		User user = new User();
		user.setEmail("fkj@eamv.dk");
		user.setRoles(new ArrayList<>());
		Role r = new Role();
		r.setRole("?");
		r.setRoleId(2);
		user.getRoles().add(r);
		userejb.create(user);
		
		UserProfile up = new UserProfile();
		up.setUser(user);
		up.setFirstname("Flemming Koch");
		up.setLastname("Jensen");
		profejb.create(up);
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
