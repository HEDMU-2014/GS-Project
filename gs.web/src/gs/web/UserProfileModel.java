package gs.web;

import java.io.Serializable;
import java.util.Optional;

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
import domain.UserProfile;

@Named
@SessionScoped
public class UserProfileModel implements Serializable {
	
	@EJB private UserProfilesBeanLocal upbl;
	@EJB private UsersBeanLocal ubl;
	private Logger logger = Logger.getLogger(UserProfileModel.class);
	@Inject UserOverviewView overview;
	private User user;
	private UserProfile userProfile;
	private boolean edit = false;

	private static final long serialVersionUID = 1L;

	@PostConstruct
	public void init() {
		userProfile = upbl.read(user.getUserid()).get();
		if(userProfile == null){
			userProfile = new UserProfile();
			userProfile.setUserid(user.getUserid());
		}
	}
	
	public void update() {
		logger.info("method update entered");
		try {
			upbl.update(userProfile);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Userprofile updated"));
			overview.init();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "User does not exist", "User does not exist"));
			}
	}
	
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
