package gs.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.logging.Logger;

import beans.UsersBeanLocal;
import domain.User;
import domain.UserProfile;

@Named
@SessionScoped
@RolesAllowed("admin")
public class UserOverviewControl implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB private UsersBeanLocal ejb;
	@Inject UserOverviewModel model;
	@Inject UserDetailModel detail;
	private Logger logger = Logger.getLogger(UserOverviewControl.class);
	
	@PostConstruct
	public void init() {
//		List<User> users = ejb.searchUsers("");
//		this.users = new ArrayList<UserWrapper>();
//		int i=0;
//		for (User user : users) {
//			UserWrapper uw = new UserWrapper();
//			uw.setId(i++);
//			uw.setUser(user);
//			this.users.add(uw);
//		}
	}

	public void search() {
		logger.info("Search : " + model.getSearchstring());
		List<User> users = ejb.searchUsers(model.getSearchstring());
		model.setUsers(new ArrayList<UserWrapper>());
		int i=0;
		for (User user : users) {
			UserWrapper uw = new UserWrapper();
			uw.setId(i++);
			uw.setUser(user);
			model.getUsers().add(uw);
		}
	}

	public String view() {
		logger.info("Selected user : " + model.getSelectedUser());
		if (model.getSelectedUser() != null && detail != null) {
			detail.setUser(model.getSelectedUser().getUser());
			detail.setEdit(false);
			model.setSelectedUser(null);
			return "/admin/userdetail.xhtml";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No row selected"));
			return null;
		}
	}

	public String update() {
		logger.info("Selected user : " + model.getSelectedUser());
		if (model.getSelectedUser() != null && detail != null) {
			detail.setUser(model.getSelectedUser().getUser());
			detail.setEdit(true);
			model.setSelectedUser(null);
			return "/admin/userdetail.xhtml";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No row selected"));
			return null;
		}
	}
	
	public String create() {
		if (detail != null) {
			detail.setUser(new User());
			detail.getUser().setUserprofile(new UserProfile());
			detail.setEdit(true);
			model.setSelectedUser(null);
			return "/admin/userdetail.xhtml";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Something very wrong"));
			return null;
		}
	}

}
