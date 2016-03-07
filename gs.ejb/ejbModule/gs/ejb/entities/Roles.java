package gs.ejb.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import gs.ejb.domain.Role;

/**
 * Entity implementation class for Entity: Roles
 *
 */
@Entity

public class Roles implements Serializable {
	private static final long serialVersionUID = 1L;

	   
	@Id
	private int roleid;
	
	@Column(length=10, nullable=false)
	private String role;

	public Roles() {
		super();
	} 
	
	public Roles(Role role) {
		update(role);
	}
	
	public Roles update(Role role) {
		this.roleid = role.getRoleid();
		this.role = role.getRole();
		return this;
	}
	
	public Role map(Role role) {
		role.setRoleid(this.roleid);
		role.setRole(this.role);
		return role;
	}
	
	public int getRoleid() {
		return this.roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}   
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Roles [roleid=" + roleid + ", role=" + role + "]";
	}
   
}
