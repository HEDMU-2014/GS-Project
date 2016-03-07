package entities;

import java.io.Serializable;
import javax.persistence.*;


@Entity
public class Roles implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int roleId;
	private String role;
	private static final long serialVersionUID = 1L;
	
	public Roles() {
		super();
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
