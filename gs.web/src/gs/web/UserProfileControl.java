package gs.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.logging.Logger;

import beans.CountryLocal;
import beans.OrganizationBeanLocal;
import beans.PictureBeanLocal;
import beans.RolesBeanLocal;
import beans.UserProfilesBeanLocal;
import beans.UsersBeanLocal;
import domain.Country;
import domain.Role;

@Named
@SessionScoped
public class UserProfileControl implements Serializable {

	@Inject
	UserProfileModel model;

	private static final long serialVersionUID = 1L;

	@EJB
	private UsersBeanLocal ubl;
	@EJB
	private UserProfilesBeanLocal upbl;
	@EJB
	private RolesBeanLocal rbl;
	@EJB
	private OrganizationBeanLocal obl;
	@EJB
	private PictureBeanLocal pbl;
	@EJB private CountryLocal cbl;
	private Logger logger = Logger.getLogger(UserProfileControl.class);

	@PostConstruct
	public void init() {
		int[] selectedRoles = new int[model.getUser().getRoles().size()];
		Iterator<Role> iter = model.getUser().getRoles().iterator();
		int i = 0;
		while (iter.hasNext()) {
			selectedRoles[i] = iter.next().getRoleId();
			i++;
		}
		model.setSelectedRoles(selectedRoles);
		model.setSelectedCountry(model.getUser().getUserprofile().getCountrycode());
	}

	public void update() {
		logger.info("method update entered");
		try {
			List<Role> selected = new ArrayList<Role>();
			for(int val : model.getSelectedRoles()){
				selected.add(rbl.read(val).get());
			}
			model.getUser().setRoles(selected);
			model.getUser().getUserprofile().setCountrycode(model.getSelectedCountry());
			ubl.update(model.getUser());
			upbl.update(model.getUserProfile());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("User + UserProfile updated"));
		} catch (Exception e) {
			System.out.println(e.toString());
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.toString(), e.getMessage()));

		}
	}

	public List<Role> getRoles() {
		return rbl.allRoles();
	}
	public List<Country> getCountries(){
		return cbl.allCountries();
	}
}
