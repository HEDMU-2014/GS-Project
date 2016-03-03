package gs.ejb.beans;

import java.util.Optional;

import javax.ejb.Local;

import gs.ejb.domain.Organization;

@Local
public interface OrganizationLocal {

	Optional<Organization> getOrganization(int orgid);

	void createOrganization(Organization org);

	void updateOrganization(Organization org);

	void deleteOrganization(Organization org);

}
