package gs.web;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.RolesBeanLocal;
import beans.UsersBeanLocal;
import domain.Role;
import domain.User;

@WebServlet("/CRUDTest")
public class CRUDTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB RolesBeanLocal rbl;
	@EJB UsersBeanLocal ubl;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Role role = new Role();
		role.setRole("Moderator");
		role.setRoleId(1);
		rbl.create(role);
		response.getWriter().append("Rolle: ").append(rbl.read(1).toString() + "\n");
		
		User user = new User();
		user.setFirstname("Tom");
		user.setLastname("Engelsen");
		user.setEmail("uninet@live.no");
		user.setOrganization("n/a");
		user.setPassword("abcdefg");
		Date date = new Date();
		user.setCreateddate(new Timestamp(date.getTime()));
		user.setLastlogin(new Timestamp(date.getTime()));
		user.setRoles(new ArrayList<>());
		user.getRoles().add(role);
		
		ubl.create(user);
		response.getWriter().append("User: ").append(ubl.read(1).toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
