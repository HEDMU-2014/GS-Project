package beans;

import java.util.ArrayList;
import java.util.List;
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

	@Override
    public void create(Role role) {
    	Roles entity = new Roles(role);
		em.persist(entity);
    }
    
	@Override
    public Optional<Role> read(int roleId) {
    	Roles role = em.find(Roles.class, roleId); 
		if (role != null) {
			return Optional.of(role.map(new Role()));
		} else {
			return Optional.empty();
		}
    }
    
	@Override
    public void update(Role role) {
    	Roles roles = em.find(Roles.class, role.getRoleId()); 
		if (roles != null) {
			roles.update(role);
		} else {
			throw new RuntimeException("Role with id " + role.getRoleId() + " not found");
		}
    }
    
	@Override
    public void delete(Role role) {
    	Roles roles = em.find(Roles.class, role.getRoleId()); 
		if (roles != null) {
			em.remove(roles);
		} else {
			throw new RuntimeException("Role with id " + role.getRoleId() + " not found");
		}
    }
	
	@Override
	public List<Role> allRoles() {
		List<Role> roles = new ArrayList<>();
		List<Roles> rolese = em.createNamedQuery("allRoles", Roles.class)
				.getResultList();
		for (Roles r : rolese) {
			roles.add(r.map(new Role()));
		}
		return roles;
	}
}
