package gs.ejb.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

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
	
	@ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
	private Collection<Users> users;

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
		role.setUsers(new ArrayList<>());
		for(Users users : this.users) {
			role.getUsers().add(users.getEmail());
		}
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
	public Collection<Users> getUsers() {
		return users;
	}

	public void setUsers(Collection<Users> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Roles [roleid=" + roleid + ", role=" + role + ", users=" + users + "]";
	}
   
}
