package gs.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import domain.User;

@Named
@SessionScoped
public class UserProfileOverviewControl implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject UserProfileOverviewModel pOModel;

	@PostConstruct
	public void init() {
		pOModel.init();
	}
	public void search() {
		pOModel.search();
	}
	
	public String view() {
		return pOModel.view();
	}

	public String update() {
		return pOModel.update();
	}
	public List<UserWrapper> getUsers() {
		return pOModel.getUsers();
	}

	public void setUsers(List<UserWrapper> users) {
		pOModel.setUsers(users);
	}

	public UserWrapper getSelectedUser() {
		return pOModel.getSelectedUser();
	}

	public void setSelectedUser(UserWrapper selectedUser) {
		pOModel.setSelectedUser(selectedUser);
	}

	public String getSearchstring() {
		return pOModel.getSearchstring();
	}

	public void setSearchstring(String searchstring) {
		pOModel.setSearchstring(searchstring);
	}
}
