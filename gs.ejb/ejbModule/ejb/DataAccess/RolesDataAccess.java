package ejb.DataAccess;

import java.util.Optional;

import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ejb.CRUD.RolesDataAccessLocal;
import ejb.CRUD.RolesDataAccessRemote;
import ejb.Entities.Roles;

/**
 * Session Bean implementation class RolesDataAccess
 */
@Stateless
@WebService
public class RolesDataAccess implements RolesDataAccessRemote, RolesDataAccessLocal {
	
	@PersistenceContext private EntityManager em;

    public RolesDataAccess() {
        // TODO Auto-generated constructor stub
    }
    
    public String greeting(String key) {
    	Roles role = em.find(Roles.class, key);
    	if (role != null)
    		return "Hi " + role.getRole();
    	else
    		return "Hi unknown";
    }
    
    public void create(String key, String value) {
    	Roles role = new Roles();
    	role.setRoleId(key);
    	role.setRole(value);
    	em.persist(role);
    }
    
    public Optional<String> read(String key) {
    	Roles role = em.find(Roles.class, key);
    	if (role != null)
    		return Optional.of(role.getRole());
    	else
    		return Optional.empty();
    }
    
    public void update(String key, String value) {
    	Roles role = em.find(Roles.class, key);
    	role.setRole(value);
    }
    
    public void delete(String key) {
    	Roles role = em.find(Roles.class, key);
    	em.remove(role);
    }

}
