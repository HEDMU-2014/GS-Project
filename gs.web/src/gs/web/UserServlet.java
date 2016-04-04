package gs.web;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.OrganizationBeanLocal;
import beans.RoleBeanLocal;
import beans.UserBeanLocal;
import domain.Organization;
import domain.Role;
import domain.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB private UserBeanLocal userejb;
	@EJB private RoleBeanLocal roleejb;
	@EJB private OrganizationBeanLocal orgejb;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		Organization org = new Organization();
//		org.setName("eamv");
//		org.setAddress("Gl. Landevej 2");
//		org.setCity("Herning");
//		org.setZip(7400);
//		orgejb.createOrg(org);
//		response.getWriter().append("Org: " + org);
		
//		Role role = new Role();
//		role.setRole("Member");
//		role.setRoleid(1);
//		roleejb.createRole(role.getRoleid(), role.getRole());
//		response.getWriter().append("Role: " + role);
		
//		User user = new User();
//		user.setEmail("fkj@eamv.dk");
//		user.setFirstname("Flemming");
//		user.setLastname("Jensen");
//		user.setPassword("password");
//		user.setRoles(new ArrayList<>());
//		user.getRoles().add(roleejb.readRole(1));
//		user.setOrganization(orgejb.readOrg(1).get());
//		user.setCreateddate(LocalDateTime.now());
//		user.setLastlogin(LocalDateTime.now());
//		userejb.createUser(user);
		String org = "";
		if(request.getParameter("org") != null)
		org = request.getParameter("org");
		response.getWriter().append("org search: " + org);
		response.getWriter().println();
		List<User> users = userejb.listMembers(org);
		response.getWriter().append("Users: " + users);
		String searchU = request.getParameter("user");
		if(searchU.length() > 0){
			response.getWriter().println();
			response.getWriter().append("user search: " + searchU);
			response.getWriter().println();
			users = userejb.searchUsers(searchU);
			response.getWriter().append("Users: " + users);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}