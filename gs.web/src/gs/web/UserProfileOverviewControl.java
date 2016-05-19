package gs.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.logging.Logger;

import beans.UserProfilesBeanLocal;
import beans.UsersBeanLocal;
import domain.User;

@Named
@SessionScoped
public class UserProfileOverviewControl implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject UserProfileOverviewModel model;

	@EJB private UsersBeanLocal ubl;
	@EJB private UserProfilesBeanLocal upbl;
	@Inject UserProfileModel detail;
	private Logger logger = Logger.getLogger(UserProfileOverviewControl.class);
	
	@PostConstruct
	public void init() {
		search("");
	}
	public void search() {
		search(model.getSearchstring());
	}
	public void search(String s){
		logger.info("Search : " + s);
		List<User> users = ubl.searchUsers(s);
		model.setUsers(new ArrayList<UserWrapper>());
		int i=0;
		for (User user : users) {
			UserWrapper uw = new UserWrapper();
			uw.setId(i++);
			uw.setUser(user);
			uw.setUserProfile(upbl.read(user.getUserid()).get());
			model.getUsers().add(uw);
		}
		
	}
	public String view() {
		return viewOrUpdate(false);
	}

	public String update() {
		return viewOrUpdate(true);
	}
	public String viewOrUpdate(boolean update){
		logger.info("Selected user : " + model.getSelectedUser());
		if (model.getSelectedUser() != null && model != null) {
			detail.setUser(model.getSelectedUser().getUser());
			detail.setUserProfile(model.getSelectedUser().getUserProfile());
			detail.setEdit(update);
			model.setSelectedUser(null);
			return "/admin/userprofile.xhtml";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No row selected"));
			return null;
		}
	}
}
