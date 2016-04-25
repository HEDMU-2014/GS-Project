package gs.web;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import beans.UserProfilesBeanLocal;
import beans.UsersBeanLocal;
import domain.User;
import domain.UserProfile;

@Named
@SessionScoped
public class UserProfileControl implements Serializable {
	
	@Inject UserProfileModel pModel;

	private static final long serialVersionUID = 1L;

	@PostConstruct
	public void init() {
		pModel.init();
	}
	
	public void update() {
		pModel.update();
	}
	
	public boolean isEdit() {
		return pModel.isEdit();
	}
	public void setEdit(boolean edit) {
		pModel.setEdit(edit);
	}
	
	public boolean isNotEdit() {
		return pModel.isNotEdit();
	}

	public User getUser() {
		return pModel.getUser();
	}

	public void setUser(User user) {
		pModel.setUser(user);
	}

	public UserProfile getUserProfile() {
		return pModel.getUserProfile();
	}

	public void setUserProfile(UserProfile userProfile) {
		pModel.setUserProfile(userProfile);
	}

	public boolean isShowUpdate() {
		return pModel.isShowUpdate();
	}
}
