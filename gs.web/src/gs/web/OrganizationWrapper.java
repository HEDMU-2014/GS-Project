package gs.web;

import domain.Organization;

public class OrganizationWrapper {
	private int id;
	private Organization organization;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Organization getOrganization() {
		return organization;
	}
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

}
