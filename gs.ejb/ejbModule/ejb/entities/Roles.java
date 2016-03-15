package ejb.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import ejb.domain.Role;

/**
 * Entity implementation class for Entity: Roles
 *
 */
@Entity

public class Roles implements Serializable {
	
	@Id
	private int roleId;
	@NotNull
	private String role;

	
	private static final long serialVersionUID = 1L;

	public Roles() {
		super();
	}


	public Roles(Role role) {
		update(role);
	}
	
	public Roles update(Role role) {
		this.roleId = role.getRoleid();
		this.role = role.getRole();
		return this;
	}
	
	public Role map(Role role) {
		role.setRoleid(this.roleId);
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
   
}
