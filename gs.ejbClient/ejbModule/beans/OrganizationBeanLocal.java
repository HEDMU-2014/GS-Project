package beans;

import java.util.List;
import java.util.Optional;

import javax.ejb.Local;

import domain.Organization;

@Local
public interface OrganizationBeanLocal {

	public Optional<Organization> read(int orgid);

	public void create(Organization org);

	public void update(Organization org);

	public void delete(Organization org);

	public List<Organization> searchOrganizations(String searchstring);

}
