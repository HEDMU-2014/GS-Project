package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import domain.Role;


@Entity
public class Roles implements Serializable {

	@Id
	private int roleId;
	private String role;
	private static final long serialVersionUID = 1L;
	
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

	@Override
	public String toString() {
		return "Roles [roleId=" + roleId + ", role=" + role + "]";
	}
}
