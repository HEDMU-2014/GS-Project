package gs.ejb;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.sql.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Users
 *
 */
@Entity

public class Users implements Serializable {

	   
	@Id
	private Integer UserID;
	private Integer RoleID;
	private String FirstName;
	private String LastName;
	private String Email;
	private String Password;
	private Date CreatedDate;
	private Date LastLogin;
	private String Organisation;
	private static final long serialVersionUID = 1L;

	public Users() {
		super();
	}   
	public Integer getUserID() {
		return this.UserID;
	}

	public void setUserID(Integer UserID) {
		this.UserID = UserID;
	}   
	public Integer getRoleID() {
		return this.RoleID;
	}

	public void setRoleID(Integer RoleID) {
		this.RoleID = RoleID;
	}   
	public String getFirstName() {
		return this.FirstName;
	}

	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}   
	public String getLastName() {
		return this.LastName;
	}

	public void setLastName(String LastName) {
		this.LastName = LastName;
	}   
	public String getEmail() {
		return this.Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}   
	public String getPassword() {
		return this.Password;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}   
	public Date getCreatedDate() {
		return this.CreatedDate;
	}

	public void setCreatedDate(Date CreatedDate) {
		this.CreatedDate = CreatedDate;
	}   
	public Date getLastLogin() {
		return this.LastLogin;
	}

	public void setLastLogin(Date LastLogin) {
		this.LastLogin = LastLogin;
	}   
	public String getOrganisation() {
		return this.Organisation;
	}

	public void setOrganisation(String Organisation) {
		this.Organisation = Organisation;
	}
   
}
