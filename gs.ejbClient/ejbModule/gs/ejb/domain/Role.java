package gs.ejb.domain;

import java.io.Serializable;
import java.util.List;

public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	private int roleid;
	private String role;
	private List<String> users;
	
	public Role() {
		
	}
	
	public Role(int roleid, String role) {
		this.roleid = roleid;
		this.role = role;
	}

	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	public List<String> getUsers() {
		return users;
	}

	public void setUsers(List<String> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Role [roleid=" + roleid + ", role=" + role + ", users=" + users + "]";
	}


}
