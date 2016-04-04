package beans;

import java.util.Optional;

import javax.ejb.Local;

import domain.Organization;

@Local
public interface OrganizationBeanLocal {

	Optional<Organization> getOrganization(int orgid);

	void createOrganization(Organization org);

	void updateOrganization(Organization org);

	void deleteOrganization(Organization org);

}
