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
import domain.LoginType;
import domain.Organization;
import domain.Role;
import domain.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB private UsersBeanLocal userejb;
	@EJB private UserProfilesBeanLocal profejb;
	@EJB private RolesBeanLocal roleejb;
	@EJB private OrganizationBeanLocal orgejb;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> users = userejb.listMembers("eamv");
		response.getWriter().append("Users : " + users);
		User user = userejb.read(1).get();
//		user.setLogintype(new LoginType());
		user.getLogintype().setId(3);
		userejb.update(user);
//		user.setUserid(0);
//		user.setEmail("awp@eamv.dk");
//		user.getUserprofile().setFirstname("Anders");
//		user.getUserprofile().setLastname("Petersen");
//		user.getUserprofile().setOrgId(1);
//		user.setRoles(new ArrayList<>());
//		user.getRoles().add(new Role(2, "?"));
//		userejb.create(user);
//		Organization org = orgejb.getOrganization(1).get();
//		response.getWriter().append("Org: " + org);
//		Role role = roleejb.read(1).get();
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
