package beans;

import java.util.Optional;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.Role;
import entities.Roles;

@Stateless
@LocalBean
public class RolesBean implements RolesBeanRemote, RolesBeanLocal {
	
	@PersistenceContext EntityManager em;

    public void create(Role role) {
    	Roles roles = new Roles();
    	roles.setRole(role.getRole());
    	em.persist(roles);
    }
    
    public Optional<Role> read(int roleId) {
    	Roles jpaRoles = em.find(Roles.class, roleId);
    	if (jpaRoles != null) {
    		Role role = new Role();
        	role.setRole(jpaRoles.getRole());
        	role.setRoleId(jpaRoles.getRoleId());
        	return Optional.of(role);
    	}
    	else
    		return Optional.empty();
    }
    
    public void update(Role role) {
    	Roles roles = em.find(Roles.class, role.getRoleId());
    	roles.setRole(role.getRole());
    }
    
    public void delete(Role role) {
    	Roles roles = em.find(Roles.class, role.getRoleId());
    	em.remove(roles);
    }
}
