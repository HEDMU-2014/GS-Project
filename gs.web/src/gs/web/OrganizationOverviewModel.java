package gs.web;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class OrganizationOverviewModel implements Serializable {
	private static final long serialVersionUID = 1L;
	private String searchstring;
	private List<OrganizationWrapper> organizations;
	private OrganizationWrapper selectedOrganization;
	


	public List<OrganizationWrapper> getOrganizations() {
		return organizations;
	}

	public void setOrganizations(List<OrganizationWrapper> organizations) {
		this.organizations = organizations;
	}

	public OrganizationWrapper getSelectedOrganization() {
		return selectedOrganization;
	}

	public void setSelectedOrganization(OrganizationWrapper selectedOrganization) {
		this.selectedOrganization = selectedOrganization;
	}

	public String getSearchstring() {
		return searchstring;
	}

	public void setSearchstring(String searchstring) {
		this.searchstring = searchstring;
	}

	
}
