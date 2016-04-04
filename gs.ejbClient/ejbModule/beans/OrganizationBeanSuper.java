package beans;

import java.util.Optional;

import domain.Organization;

public interface OrganizationBeanSuper {
public void createOrg(Organization org);
public Optional<Organization> readOrg(int orgID);
public void updateOrg(Organization org);
public void deleteOrg(int orgID);
}
