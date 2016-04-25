package gs.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import domain.User;
import domain.UserProfile;

@Named
@SessionScoped
public class UserProfileModel implements Serializable {
	
	private User user;
	private UserProfile userProfile;
	private boolean edit = false;

	private static final long serialVersionUID = 1L;

	public boolean isEdit() {
		return edit;
	}
	public void setEdit(boolean edit) {
		this.edit = edit;
	}
	
	public boolean isNotEdit() {
		return !edit;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public boolean isShowUpdate() {
		return edit && user.getUserid() > 0;
	}
}
