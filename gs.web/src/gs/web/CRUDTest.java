package gs.web;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.OrganizationBeanLocal;
import beans.RolesBeanLocal;
import beans.UserPictureCommentsBeanLocal;
import beans.UserProfilesBeanLocal;
import beans.UsersBeanLocal;
import domain.Organization;
import domain.Role;
import domain.User;
import domain.UserPictureComment;
import domain.UserProfile;

@WebServlet("/CRUDTest")
public class CRUDTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private RolesBeanLocal rbl;
	@EJB
	private OrganizationBeanLocal obl;
	@EJB
	private UsersBeanLocal ubl;
	@EJB
	private UserPictureCommentsBeanLocal upcl;
	@EJB
	private UserProfilesBeanLocal upl;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		Role role = new Role();
//		role.setRole("Admin");
//		role.setRoleId(2);
//		rbl.create(role);
//		response.getWriter().append("Role: ").append(rbl.read(1).toString() + "\n");

//		Organization org = new Organization();
//		org.setName("EAMV");
//		org.setAddress("Gl. Landevej 2");
//		org.setZip(7400);
//		org.setCity("Herning");
//		obl.createOrganization(org);
//		response.getWriter().append("Org: ").append(obl.getOrganization(1).toString() + "\n");

//		User user = new User();
//		user.setEmail("uninet@live.no");
//		user.setPassword("abcdefg");
//		user.setLastlogin(Calendar.getInstance());
//		user.setRoles(new ArrayList<>());
//		user.getRoles().add(role);
		

//		ubl.create(user);
//		UserProfile up = new UserProfile();
//		up.setUser(user);
//		up.setFirstname("Tom");
//		up.setLastname("Engelsen");
//		up.setOrganization(org);
//		up.setCreateddate(Calendar.getInstance());
//		
//		System.out.println(up);
//		
//		upl.create(up);
		
		List<User> users = ubl.searchUsers("Tom");

		for (User u : users)
			response.getWriter().append("User: " + u.toString() + "\n");
		// response.getWriter().append("User added:
		// ").append(ubl.read(1).toString());

//		UserPictureComment upc = new UserPictureComment();
//		upc.setUserId(user.getUserid());
//		upc.setMessage("woopdedoo");
//		upc.setPictureId(14245);
//		upc.setCreatedDate(LocalDateTime.now());
//		upcl.create(upc);
		
		
		response.getWriter().append("UserPictureComment: " + upcl.searchCommentsByUserId(0));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
