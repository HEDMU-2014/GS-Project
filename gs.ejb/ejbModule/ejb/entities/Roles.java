package ejb.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Entity implementation class for Entity: Roles
 *
 */
@Entity

public class Roles implements Serializable {
	
	@Id
	private String roleId;
	@NotNull
	private String role;

	
	private static final long serialVersionUID = 1L;

	public Roles() {
		super();
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
   
}
