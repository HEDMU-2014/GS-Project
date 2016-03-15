package ejb.beans;

import java.util.Optional;

import javax.ejb.Remote;

import ejb.domain.Organization;

@Remote
public interface OrganizationRemote {

	Optional<Organization> getOrganization(int orgid);

	void createOrganization(Organization org);

	void updateOrganization(Organization org);

	void deleteOrganization(Organization org);

}