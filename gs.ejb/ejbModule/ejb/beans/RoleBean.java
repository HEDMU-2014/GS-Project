package ejb.beans;

import java.util.Optional;

import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ejb.beans.RoleLocal;
import ejb.beans.RoleRemote;
import ejb.entities.Role;

/**
 * Session Bean implementation class RolesDataAccess
 */
@Stateless
@WebService
public class RoleBean implements RoleRemote, RoleLocal {
	
	@PersistenceContext private EntityManager em;

    public RoleBean() {
        // TODO Auto-generated constructor stub
    }
    
    public String greeting(String key) {
    	Role role = em.find(Role.class, key);
    	if (role != null)
    		return "Hi " + role.getRole();
    	else
    		return "Hi unknown";
    }
    
    public void create(String key, String value) {
    	Role role = new Role();
    	role.setRoleId(key);
    	role.setRole(value);
    	em.persist(role);
    }
    
    public Optional<String> read(String key) {
    	Role role = em.find(Role.class, key);
    	if (role != null)
    		return Optional.of(role.getRole());
    	else
    		return Optional.empty();
    }
    
    public void update(String key, String value) {
    	Role role = em.find(Role.class, key);
    	role.setRole(value);
    }
    
    public void delete(String key) {
    	Role role = em.find(Role.class, key);
    	em.remove(role);
    }

}
