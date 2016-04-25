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
public class UserProfileOverviewModel implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB private UsersBeanLocal usersb;
	@EJB private UserProfilesBeanLocal upbl;
	@Inject UserProfileControl pControl;
	private Logger logger = Logger.getLogger(UserProfileOverviewModel.class);
	private String searchstring;
	private List<UserWrapper> users;
	private UserWrapper selectedUser;

	@PostConstruct
	public void init() {
		search("");
	}
	public void search() {
		search(searchstring);
	}
	public void search(String s){
		logger.info("Search : " + s);
		List<User> users = usersb.searchUsers(s);
		this.users = new ArrayList<UserWrapper>();
		int i=0;
		for (User user : users) {
			UserWrapper uw = new UserWrapper();
			uw.setId(i++);
			uw.setUser(user);
			uw.setUserProfile(upbl.read(user.getUserid()).get());
			this.users.add(uw);
		}
		
	}
	public String view() {
		return viewOrUpdate(false);
	}

	public String update() {
		return viewOrUpdate(true);
	}
	public String viewOrUpdate(boolean update){
		logger.info("Selected user : " + selectedUser);
		if (this.selectedUser != null && pControl != null) {
			pControl.setUser(this.selectedUser.getUser());
			pControl.setUserProfile(this.selectedUser.getUserProfile());
			pControl.setEdit(update);
			pControl.init();
			this.selectedUser = null;
			return "/userprofile.xhtml";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No row selected"));
			return null;
		}
	}
	public List<UserWrapper> getUsers() {
		return users;
	}

	public void setUsers(List<UserWrapper> users) {
		this.users = users;
	}

	public UserWrapper getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(UserWrapper selectedUser) {
		this.selectedUser = selectedUser;
	}

	public String getSearchstring() {
		return searchstring;
	}

	public void setSearchstring(String searchstring) {
		this.searchstring = searchstring;
	}

}
