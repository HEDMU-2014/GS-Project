package gs.web;

import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.CountryLocal;
import beans.LoginTypesBeanLocal;
import beans.OrganizationBeanLocal;
import beans.RolesBeanLocal;
import beans.UsersBeanLocal;
import domain.Country;
import domain.LoginType;
import domain.Organization;
import domain.Role;
import domain.User;
import domain.UserProfile;

/**
 * Servlet implementation class InitDB
 */
@WebServlet("/InitDB")
public class InitDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB private OrganizationBeanLocal orgejb;    
    @EJB private RolesBeanLocal roleejb;    
    @EJB private CountryLocal countryejb;  
    @EJB private LoginTypesBeanLocal ltejb;
    @EJB private UsersBeanLocal userejb;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Organization org = new Organization();
		org.setOrgId(0);
		org.setName("EAMV");
		org.setAddress("Gl. Landevej 2");
		org.setCity("Herning");
		org.setZip(7400);
		orgejb.createOrganization(org);
		response.getWriter().println("Org added : " + org);
		
		Role role1 = new Role();
		role1.setRoleId(1);
		role1.setRole("Member");
		roleejb.create(role1);
		response.getWriter().println("Role added : " + role1);
		Role role2 = new Role();
		role2.setRoleId(2);
		role2.setRole("Moderator");
		roleejb.create(role2);
		response.getWriter().println("Role added : " + role2);
		Role role3 = new Role();
		role3.setRoleId(3);
		role3.setRole("Admin");
		roleejb.create(role3);
		response.getWriter().println("Role added : " + role3);
		
		Country country = new Country();
		country.setCountrycode("DK");
		country.setCountryname("Denmark");
		countryejb.createCountry(country);
		response.getWriter().println("Country added : " + country);
		
		LoginType lt = new LoginType();
		lt.setId(1);
		lt.setName("Facebook");
		ltejb.create(lt);
		response.getWriter().println("LoginType added : " + lt);
		lt.setId(2);
		lt.setName("Google");
		ltejb.create(lt);
		response.getWriter().println("LoginType added : " + lt);
		lt.setId(3);
		lt.setName("Pinterest");
		ltejb.create(lt);
		response.getWriter().println("LoginType added : " + lt);
		lt.setId(4);
		lt.setName("Twitter");
		ltejb.create(lt);
		response.getWriter().println("LoginType added : " + lt);
		lt.setId(5);
		lt.setName("LinkedIn");
		ltejb.create(lt);
		response.getWriter().println("LoginType added : " + lt);
		lt.setId(6);
		lt.setName("Taranui");
		ltejb.create(lt);
		response.getWriter().println("LoginType added : " + lt);
		
		User user = new User();
		user.setUserid(0);
		user.setEmail("hi@eamv.dk");
		user.setLastlogin(Calendar.getInstance());
		user.setPassword("123");
		user.setLogintype(lt);
		user.setRoles(Arrays.asList(role1, role3));
		user.setUserprofile(new UserProfile());
		user.getUserprofile().setFirstname("Hans");
		user.getUserprofile().setLastname("Iversen");
		user.getUserprofile().setCity("Herning");
		user.getUserprofile().setCreateddate(Calendar.getInstance());
		user.getUserprofile().setJob("Adjunkt");
		user.getUserprofile().setGender('M');
		user.getUserprofile().setLocation("Jylland");
		user.getUserprofile().setOrgId(1);
		user.getUserprofile().setCountrycode("DK");
		userejb.create(user);
		response.getWriter().println("User added : " + user);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
