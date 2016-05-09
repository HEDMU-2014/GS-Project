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

import beans.OrganizationBeanLocal;
import domain.Organization;


@Named
@SessionScoped
public class OrganizationOverviewControl implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB private OrganizationBeanLocal ejb;
	@Inject OrganizationOverviewModel model;
	@Inject OrganizationDetailModel detail;
	private Logger logger = Logger.getLogger(OrganizationOverviewControl.class);
	
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
		logger.info("Search : " + model.getSearchstring());
		List<Organization> organizations = ejb.searchOrganizations(model.getSearchstring());
		model.setOrganizations(new ArrayList<OrganizationWrapper>());
		int i=0;
		for (Organization organization : organizations) {
			OrganizationWrapper ow = new OrganizationWrapper();
			ow.setId(i++);
			ow.setOrganization(organization);
			model.getOrganizations().add(ow);
		}
	}

	public String view() {
		logger.info("Selected Organization : " + model.getSelectedOrganization());
		if (model.getSelectedOrganization() != null && detail != null) {
			detail.setOrganization(model.getSelectedOrganization().getOrganization());
			detail.setEdit(false);
			model.setSelectedOrganization(null);
			return "/organizationdetail.xhtml";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No row selected"));
			return null;
		}
	}

	public String update() {
		logger.info("Selected organization : " + model.getSelectedOrganization());
		if (model.getSelectedOrganization() != null && detail != null) {
			detail.setOrganization(model.getSelectedOrganization().getOrganization());
			detail.setEdit(true);
			model.setSelectedOrganization(null);
			return "/organizationdetail.xhtml";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No row selected"));
			return null;
		}
	}
	
	public String create() {
		if (detail != null) {
			detail.setOrganization(new Organization());
//			detail.getOrganization().setUserprofile(new UserProfile());
			detail.setEdit(true);
			model.setSelectedOrganization(null);
			return "/organizationdetail.xhtml";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Something very wrong"));
			return null;
		}
	}

}
