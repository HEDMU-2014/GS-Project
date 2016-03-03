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
public class OrganizationBean implements OrganizationRemote, OrganizationLocal {
	@PersistenceContext private EntityManager em;

	@Override
	public Optional<Organization> getOrganization(int orgid) {
		Organizations org = em.find(Organizations.class, orgid); 
		if (org != null) {
			return Optional.of(org.map(new Organization()));
		} else {
			return Optional.empty();
		}
	}
	
	@Override
	public void createOrganization(Organization org) {
		Organizations entity = new Organizations(org);
		em.persist(entity);
	}
	
	@Override
	public void updateOrganization(Organization org) {
		Organizations entity = em.find(Organizations.class, org.getOrgId()); 
		if (entity != null) {
			entity.update(org);
		} else {
			throw new RuntimeException("Organization with id " + org.getOrgId() + " not found");
		}
	}
	
	@Override
	public void deleteOrganization(Organization org) {
		Organization entity = em.find(Organization.class, org.getOrgId()); 
		if (entity != null) {
			em.remove(entity);
		} else {
			throw new RuntimeException("Organization with id " + org.getOrgId() + " not found");
		}
	}



}
