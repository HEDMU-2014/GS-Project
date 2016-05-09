package entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import domain.Role;


@Entity
@NamedQueries({
	@NamedQuery(name = "allRoles", 
			query = "SELECT r FROM Roles r ")
})

public class Roles implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int roleId;
	private String role;
	@ManyToMany(mappedBy="roles")
	private Collection<Users> users;
	
	public Roles() {
		super();
	}
	
	public Roles(Role role) {
		update(role);
	}
	
	public Roles update(Role role) {
		this.roleId = role.getRoleId();
		this.role = role.getRole();
		return this;
	}
	
	public Role map(Role role) {
		role.setRoleId(this.roleId);
		role.setRole(this.role);
		return role;
	}
	
	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Collection<Users> getUsers() {
		return users;
	}

	public void setUsers(Collection<Users> users) {
		this.users = users;
	}
	
}
