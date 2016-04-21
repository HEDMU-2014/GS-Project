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
import beans.UsersBeanLocal;
import domain.LoginType;
import domain.Organization;
import domain.Role;
import domain.User;
import domain.UserPictureComment;
import domain.UserProfile;

@WebServlet("/CRUDTest")
public class CRUDTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	RolesBeanLocal rbl;
	@EJB
	OrganizationBeanLocal obl;
	@EJB
	UsersBeanLocal ubl;
	@EJB
	UserPictureCommentsBeanLocal upcl;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		Role role = new Role();
//		role.setRole("Cat");
//		role.setRoleId(3);
//		rbl.create(role);
//		response.getWriter().append("Role: ").append(rbl.read(1).toString() + "\n");
//
//		Organization org = new Organization();
//		org.setName("EAMV1");
//		org.setAddress("Gl. Landevej 2");
//		org.setZip(7400);
//		org.setCity("Herning");
//		obl.createOrganization(org);
//		response.getWriter().append("Org: ").append(obl.getOrganization(1).toString() + "\n");
//
//		org = obl.getOrganization(1).get();
//		UserProfile up = new UserProfile();
//		User user = new User();
//		user.setUserprofile(up);
//		up.setUserid(user.getUserid());
//		up.setFirstname("Tom");
//		up.setLastname("Engelsen");
//		user.setEmail("uninet@live.no");
//		up.setOrgId(org.getOrgId());
//		user.setPassword("abcdefg");
//		up.setCreateddate(Calendar.getInstance());
//		user.setLastlogin(Calendar.getInstance());
//		user.setRoles(new ArrayList<>());
//		user.getRoles().add(role);
//		LoginType lt = new LoginType();
//		lt.setId(1);
//		lt.setName("taranui");
//		user.setLogintype(lt);
//		ubl.create(user);
//		List<User> users = ubl.listMembers("EAMV");
//
//		for (User u : users)
//			response.getWriter().append("User: " + u.toString() + "\n");
//		// response.getWriter().append("User added:
//		// ").append(ubl.read(1).toString());
//
//		UserPictureComment upc = new UserPictureComment();
//		upc.setUserId(user.getUserid());
//		upc.setMessage("woopdedoo");
//		upc.setPictureId(14245);
//		upc.setCreatedDate(LocalDateTime.now());
//		upcl.create(upc);
//		
//		
//		response.getWriter().append("UserPictureComment: " + upcl.searchCommentsByUserId(0));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
