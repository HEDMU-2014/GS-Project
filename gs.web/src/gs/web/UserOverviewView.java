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

import beans.UsersBeanLocal;
import domain.User;
import domain.UserProfile;

@Named
@SessionScoped
public class UserOverviewView implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB private UsersBeanLocal ejb;
	@Inject UserDetailView detail;
	private Logger logger = Logger.getLogger(UserOverviewView.class);
	private String searchstring;
	private List<UserWrapper> users;
	private UserWrapper selectedUser;
	
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
		logger.info("Search : " + searchstring);
		List<User> users = ejb.searchUsers(searchstring);
		this.users = new ArrayList<UserWrapper>();
		int i=0;
		for (User user : users) {
			UserWrapper uw = new UserWrapper();
			uw.setId(i++);
			uw.setUser(user);
			this.users.add(uw);
		}
	}

	public String view() {
		logger.info("Selected user : " + selectedUser);
		if (this.selectedUser != null && detail != null) {
			detail.setUser(this.selectedUser.getUser());
			detail.setEdit(false);
			detail.init();
			this.selectedUser = null;
			return "/userdetail.xhtml";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No row selected"));
			return null;
		}
	}

	public String update() {
		logger.info("Selected user : " + selectedUser);
		if (this.selectedUser != null && detail != null) {
			detail.setUser(this.selectedUser.getUser());
			detail.setEdit(true);
			detail.init();
			this.selectedUser = null;
			return "/userdetail.xhtml";
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
			detail.init();
			this.selectedUser = null;
			return "/userdetail.xhtml";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Something very wrong"));
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
