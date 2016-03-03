package gs.ejb;

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
	private Integer RoleID;
	private Integer TypeID;
	private String Role;
	private static final long serialVersionUID = 1L;

	public Roles() {
		super();
	}   
	public Integer getRoleID() {
		return this.RoleID;
	}

	public void setRoleID(Integer RoleID) {
		this.RoleID = RoleID;
	}   
	public Integer getTypeID() {
		return this.TypeID;
	}

	public void setTypeID(Integer TypeID) {
		this.TypeID = TypeID;
	}   
	public String getRole() {
		return this.Role;
	}

	public void setRole(String Role) {
		this.Role = Role;
	}
   
}
