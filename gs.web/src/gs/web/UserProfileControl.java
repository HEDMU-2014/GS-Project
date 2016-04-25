package gs.web;

import java.io.Serializable;

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

@Named
@SessionScoped
public class UserProfileControl implements Serializable {
	
	@Inject UserProfileModel model;

	private static final long serialVersionUID = 1L;

	@EJB private UsersBeanLocal ubl;
	@EJB private UserProfilesBeanLocal upbl;
	private Logger logger = Logger.getLogger(UserProfileControl.class);
	
	@PostConstruct
	public void init() {
	}
	public void update() {
		logger.info("method update entered");
		try {
			ubl.update(model.getUser());
			upbl.update(model.getUserProfile());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("User + UserProfile updated"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.toString(), e.getMessage()));
		}
	}
	
}
