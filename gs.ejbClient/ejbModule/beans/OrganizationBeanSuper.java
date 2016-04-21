package beans;

import java.util.Optional;

import domain.Organization;

public interface OrganizationBeanSuper {
void createOrg(Organization org);
Optional<Organization> readOrg(int orgID);
void updateOrg(Organization org);
void deleteOrg(int orgID);
}
