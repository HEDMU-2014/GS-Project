package beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Roles;

@Stateless
@LocalBean
public class RolesBean implements RolesBeanRemote, RolesBeanLocal {
	
	@PersistenceContext EntityManager em;

    public void create(String role) {
    	Roles roles = new Roles();
    	roles.setRole(role);
    	em.persist(roles);
    }
    
    public String read(int roleId) {
    	return em.find(Roles.class, roleId).getRole();
    }
    
    public void update(int roleId, String role) {
    	Roles roles = em.find(Roles.class, roleId);
    	roles.setRole(role);
    }
    
    public void delete(int roleId) {
    	Roles roles = em.find(Roles.class, roleId);
    	em.remove(roles);
    }
}
