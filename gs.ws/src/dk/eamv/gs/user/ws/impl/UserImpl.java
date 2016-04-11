package dk.eamv.gs.user.ws.impl;


import java.util.GregorianCalendar;
import java.util.Optional;

import javax.ejb.EJB;
import javax.jws.WebService;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import beans.UsersBeanLocal;
import dk.eamv.gs.user.ws.User;

@WebService(serviceName = "UserService", endpointInterface = "dk.eamv.gs.user.ws.User", targetNamespace = "http://ws.user.gs.eamv.dk/")
public class UserImpl implements User {
	@EJB private UsersBeanLocal ejb;
	public boolean createUser(dk.eamv.gs.User user) {
		return false;
	}

	public dk.eamv.gs.User getUser(java.lang.String email) {
		dk.eamv.gs.User user = null;
		Optional<domain.User> opt = ejb.read(email);
		if (opt.isPresent()) {
			domain.User domain = opt.get();
			user = new dk.eamv.gs.User();
			user.setUserid(domain.getUserid());
//			user.setFirstname(domain.getFirstname());
//			user.setLastname(domain.getLastname());
			user.setEmail(domain.getEmail());
			user.setPassword(domain.getPassword());
			try {
				GregorianCalendar cal = new GregorianCalendar();
//				cal.setTimeInMillis(domain.getCreateddate().getTimeInMillis());
				user.setCreateddate(DatatypeFactory.newInstance().newXMLGregorianCalendar(cal));
				if (domain.getLastlogin() != null) {
					cal.setTimeInMillis(domain.getLastlogin().getTimeInMillis());
					user.setLastlogin(DatatypeFactory.newInstance().newXMLGregorianCalendar(cal));
				}
			} catch (DatatypeConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			if (domain.getOrganization() != null) {
//				dk.eamv.gs.Organization org = new dk.eamv.gs.Organization();
//				org.setOrgid(domain.getOrganization().getOrgId());
//				org.setName(domain.getOrganization().getName());
//				org.setAddress(domain.getOrganization().getAddress());
//				org.setZip(domain.getOrganization().getZip());
//				org.setCity(domain.getOrganization().getCity());
//				user.setOrganization(org);
//			}
			for (domain.Role drole : domain.getRoles()) {
				dk.eamv.gs.Role role = new dk.eamv.gs.Role();
				role.setRoleid(drole.getRoleId());
				role.setRole(drole.getRole());
				user.getRole().add(role);
			}
		}
		return user;
	}
}