package gs.web;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class UserOverviewModel implements Serializable {
	private static final long serialVersionUID = 1L;
	private String searchstring;
	private List<UserWrapper> users;
	private UserWrapper selectedUser;
	


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
