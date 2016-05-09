package gs.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import domain.Organization;

@Named()
@SessionScoped
public class OrganizationDetailModel implements Serializable {
	private static final long serialVersionUID = 1L;
	private Organization organization;
	private boolean edit = false;
	
	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
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
		return edit && organization.getOrgId() == 0;
	}
	public boolean isShowUpdate() {
		return edit && organization.getOrgId() > 0;
	}
	public boolean isShowDelete() {
		return organization.getOrgId() > 0;
	}

}
