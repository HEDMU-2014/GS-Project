package beans;

import java.util.Optional;

import javax.ejb.Remote;

import domain.Organization;

@Remote
public interface OrganizationBeanRemote {

	Optional<Organization> getOrganization(int orgid);

	void createOrganization(Organization org);

	void updateOrganization(Organization org);

	void deleteOrganization(Organization org);

}
