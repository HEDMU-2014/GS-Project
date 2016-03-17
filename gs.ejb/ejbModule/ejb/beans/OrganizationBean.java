package ejb.beans;

import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ejb.domain.Organization;
import ejb.entities.OrganizationEntity;

/**
 * Session Bean implementation class OrganizationBean
 */
@Stateless
public class OrganizationBean implements OrganizationRemote, OrganizationLocal {
	@PersistenceContext private EntityManager em;

	@Override
	public Optional<Organization> getOrganization(int orgid) {
		Optional<Organization> opt = Optional.empty();
		OrganizationEntity org = em.find(OrganizationEntity.class, orgid); 
		if (org != null) {
			opt = Optional.of(org.map(new Organization()));
		}
		return opt;
	}
	
	@Override
	public void createOrganization(Organization org) {
		OrganizationEntity entity = new OrganizationEntity(org);
		em.persist(entity);
	}
	
	@Override
	public void updateOrganization(Organization org) {
		OrganizationEntity entity = em.find(OrganizationEntity.class, org.getOrgId()); 
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