package beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import beans.RoleBeanLocal;
import beans.RoleBeanRemote;
import domain.Role;
import entities.Roles;

/**
 * Session Bean implementation class RoleBean
 */
@Stateless
public class RoleBean implements RoleBeanRemote, RoleBeanLocal {

	@PersistenceContext
	private EntityManager em;
	
    public RoleBean() {
    }

	@Override
	public void createRole(int roleID, String role) {
		Roles newRole = new Roles();
		newRole.setRoleID(roleID);
		newRole.setRole(role);
		em.persist(newRole);
	}

	@Override
	public Role readRole(int roleID) {
		Roles entityRole = em.find(Roles.class, roleID);
		Role domRole = entityRole.getDomRole(new Role());
		return domRole;
	}

	@Override
	public void updateRole(int roleID, String role) {
		Roles entityRole = em.find(Roles.class, roleID);
		entityRole.setRole(role);
	}

	@Override
	public void deleteRole(int roleID) {
		Roles entityRole = em.find(Roles.class, roleID);
		em.remove(entityRole);
	}

}
