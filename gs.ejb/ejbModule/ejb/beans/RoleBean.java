package ejb.beans;

import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ejb.domain.Role;
import ejb.entities.Roles;

/**
 * Session Bean implementation class RoleBean
 */
@Stateless
public class RoleBean implements RoleRemote, RoleLocal {
	@PersistenceContext private EntityManager em;

	@Override
	public Optional<Role> getRole(int roleid) {
		Optional<Role> opt = Optional.empty();
		Roles role = em.find(Roles.class, roleid); 
		if (role != null) {
			opt = Optional.of(role.map(new Role()));
		}
		return opt;
	}
	
	@Override
	public void createRole(Role role) {
		Roles entity = new Roles(role);
		em.persist(entity);
	}
	
	@Override
	public void updateRole(Role role) {
		Roles roles = em.find(Roles.class, role.getRoleid()); 
		if (roles != null) {
			roles.update(role);
		} else {
			throw new RuntimeException("Role with id " + role.getRoleid() + " not found");
		}
	}
	
	@Override
	public void deleteRole(Role role) {
		Roles roles = em.find(Roles.class, role.getRoleid()); 
		if (roles != null) {
			em.remove(roles);
		} else {
			throw new RuntimeException("Role with id " + role.getRoleid() + " not found");
		}
	}


}