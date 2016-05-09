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

import beans.OrganizationBeanLocal;


@Named()
@SessionScoped
public class OrganizationDetailControl implements Serializable {
	private static final long serialVersionUID = 3193006383857093L;
	@EJB private OrganizationBeanLocal ejb;
	@Inject OrganizationDetailModel model;
	private Logger logger = Logger.getLogger(OrganizationDetailControl.class);
	
	@PostConstruct
	public void init() {
	}
	
	public void create() {
		logger.info("method create entered");
		try {
//			model.getOrganization().getUserprofile().setCreateddate(Calendar.getInstance());
//			model.getOrganization().setLastlogin(Calendar.getInstance());
//			model.getOrganization().setLogintype(new LoginType());
//			model.getOrganization().getLogintype().setId(1);
//			model.getOrganization().setRoles(new ArrayList<>());
			ejb.create(model.getOrganization());
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Organization created"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Organization allready exists", "Organization allready exists"));
		}
	}
	public void delete() {
		logger.info("method delete entered");
		try {
			ejb.delete(model.getOrganization());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Organization deleted"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Organization does not exist", "Organization does not exist"));
		}
	}
	public void update() {
		logger.info("method update entered");
		try {
			ejb.update(model.getOrganization());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Organization updated"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Organization does not exist", "Organization does not exist"));
		}
	}
	


}
