package domain;

public class Role {

	private int roleId;
	private String role;
	
	public Role() {
		super();
	}
	
	public Role(int roleid, String role) {
		super();
		this.roleId = roleid;
		this.role = role;
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
		return "Role [roleId=" + roleId + ", role=" + role + "]";
	}

}
