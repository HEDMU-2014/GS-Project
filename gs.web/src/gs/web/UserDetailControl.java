package gs.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.logging.Logger;

import beans.UsersBeanLocal;
import domain.LoginType;
import domain.User;

@Named()
@SessionScoped
public class UserDetailControl implements Serializable {
	private static final long serialVersionUID = 3193006383857093L;
	@EJB private UsersBeanLocal ejb;
	@Inject UserOverviewView overview;
	private Logger logger = Logger.getLogger(UserDetailControl.class);
	private User user;
	private boolean edit = false;
	
	@PostConstruct
	public void init() {
	}
	
	public void create() {
		logger.info("method create entered");
		try {
			user.getUserprofile().setCreateddate(Calendar.getInstance());
			user.setLastlogin(Calendar.getInstance());
			user.setLogintype(new LoginType());
			user.getLogintype().setId(1);
			user.setRoles(new ArrayList<>());
			ejb.create(user);
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("User created"));
			overview.init();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "User allready exists", "User allready exists"));
		}
	}
	public void delete() {
		logger.info("method delete entered");
		try {
			ejb.delete(user);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("User deleted"));
			overview.init();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "User does not exist", "User does not exist"));
		}
	}
	public void update() {
		logger.info("method update entered");
		try {
			ejb.update(user);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("User updated"));
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
	
	public boolean isShowCreate() {
		return edit && user.getUserid() == 0;
	}
	public boolean isShowUpdate() {
		return edit && user.getUserid() > 0;
	}
	public boolean isShowDelete() {
		return user.getUserid() > 0;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
