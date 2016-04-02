package gs.ejb.beans;

import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import gs.ejb.domain.Organization;
import gs.ejb.entities.Organizations;

/**
 * Session Bean implementation class OrganizationBean
 */
@Stateless
public class OrganizationBean implements OrganizationBeanRemote, OrganizationBeanLocal {

	@PersistenceContext
	private EntityManager em;

	public OrganizationBean() {
	}

	@Override
	public void createOrg(Organization org) {
		Organizations organ = new Organizations(org);
		em.persist(organ);
	}

	@Override
	public Optional<Organization> readOrg(int orgID) {
		Optional<Organization> org = Optional.empty();
		Organizations organ = em.find(Organizations.class, orgID);
		if (organ != null)
			org = Optional.of(organ.map(new Organization()));
		return org;
	}

	@Override
	public void updateOrg(Organization org) {
		Organizations organ = em.find(Organizations.class, org.getOrgId());
		organ.map(org);
	}

	@Override
	public void deleteOrg(int orgID) {
		Organizations organ = em.find(Organizations.class, orgID);
		em.remove(organ);
	}

}
