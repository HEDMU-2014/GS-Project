package gs.ejb.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Roles
 *
 */
@Entity

public class Roles implements Serializable {

	   
	@Id
	private Integer roleID;
	private Integer typeID;
	private String role;
	private static final long serialVersionUID = 1L;

	public Roles() {
		super();
	}   
	public Integer getRoleID() {
		return this.roleID;
	}

	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}   
	public Integer getTypeID() {
		return this.typeID;
	}

	public void setTypeID(Integer typeID) {
		this.typeID = typeID;
	}   
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}
   
}
