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

@Named()
@SessionScoped
public class UserDetailControl implements Serializable {
	private static final long serialVersionUID = 3193006383857093L;
	@EJB private UsersBeanLocal ejb;
	@Inject UserDetailModel model;
	private Logger logger = Logger.getLogger(UserDetailControl.class);
	
	@PostConstruct
	public void init() {
	}
	
	public void create() {
		logger.info("method create entered");
		try {
			model.getUser().getUserprofile().setCreateddate(Calendar.getInstance());
			model.getUser().setLastlogin(Calendar.getInstance());
			model.getUser().setLogintype(new LoginType());
			model.getUser().getLogintype().setId(1);
			model.getUser().setRoles(new ArrayList<>());
			ejb.create(model.getUser());
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("User created"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "User allready exists", "User allready exists"));
		}
	}
	public void delete() {
		logger.info("method delete entered");
		try {
			ejb.delete(model.getUser());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("User deleted"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "User does not exist", "User does not exist"));
		}
	}
	public void update() {
		logger.info("method update entered");
		try {
			ejb.update(model.getUser());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("User updated"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "User does not exist", "User does not exist"));
		}
	}
	


}
