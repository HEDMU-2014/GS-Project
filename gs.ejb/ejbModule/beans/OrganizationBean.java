package beans;

import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.Organization;
import entities.Organizations;

/**
 * Session Bean implementation class OrganizationBean
 */
@Stateless
public class OrganizationBean implements OrganizationBeanRemote, OrganizationBeanLocal {
	@PersistenceContext private EntityManager em;

	@Override
	public Optional<Organization> getOrganization(int orgid) {
		Optional<Organization> opt = Optional.empty();
		Organizations org = em.find(Organizations.class, orgid); 
		if (org != null) {
			opt = Optional.of(org.map(new Organization()));
		}
		return opt;
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

	@Override
	public Optional<Organization> read(int orgid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Organization org) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Organization org) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Organization org) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Organization> searchOrganizations(String searchstring) {
		// TODO Auto-generated method stub
		return null;
	}



}
