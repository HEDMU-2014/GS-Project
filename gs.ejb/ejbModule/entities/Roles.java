package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import domain.Role;

@Entity

public class Roles implements Serializable {

	@Id
	private int roleID;
	@Column(length = 50, nullable = false)
	private String role;
	private static final long serialVersionUID = 1L;

	public Roles() {
	}

	public Roles(Role role) {
		getEntityRoles(role);
	}

	public Roles getEntityRoles(Role role) {
		this.setRoleID(role.getRoleid());
		this.setRole(role.getRole());
		return this;
	}

	public int getRoleID() {
		return this.roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Role getDomRole(Role role) {
		role.setRoleid(this.roleID);
		role.setRole(this.role);
		return role;
	}
}
