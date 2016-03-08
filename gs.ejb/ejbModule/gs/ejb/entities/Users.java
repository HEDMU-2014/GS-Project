package gs.ejb.entities;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

import gs.ejb.domain.User;

/**
 * Entity implementation class for Entity: Users
 *
 */
@Entity

public class Users implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userID;
	private int roleID;
	@Column(length=50, nullable=false)
	private String firstName;
	@Column(length=50, nullable=false)
	private String lastName;
	@Column(length=50, nullable=false, unique=true)
	@Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\." + "[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
			+ "(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9]"
			+ "(?:[a-z0-9-]*[a-z0-9])?", message = "{invalid.email}")
	private String email;
	@Column(length=50, nullable=false)
	private String password;
	private LocalDateTime createdDate;
	private LocalDateTime lastLogin;
	private String organisation;
	
	private static final long serialVersionUID = 1L;

	public Users() {
	}
	public Users(User user){
		getEntityUsers(user);
	}
	public Users getEntityUsers(User user){
		Users u = new Users();
		u.setCreatedDate(user.getCreateddate());
		u.setEmail(user.getEmail());
		u.setFirstName(user.getFirstname());
		u.setLastLogin(user.getLastlogin());
		u.setLastName(user.getLastname());
		u.setOrganisation(user.getOrganization());
		u.setPassword(user.getPassword());
		u.setUserID(user.getUserid());
		return u;
	}
	public int getUserID() {
		return this.userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getRoleID() {
		return this.roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getLastLogin() {
		return this.lastLogin;
	}

	public void setLastLogin(LocalDateTime lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getOrganisation() {
		return this.organisation;
	}

	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}

	public User getDomUser() {
		User domUser = new User();
		domUser.setUserid(this.userID);
		domUser.setFirstname(this.firstName);
		domUser.setLastname(this.lastName);
		domUser.setPassword(this.password);
		domUser.setCreateddate(this.createdDate);
		domUser.setEmail(this.email);
		domUser.setOrganization(this.organisation);
		domUser.setLastlogin(this.lastLogin);
		return domUser;
	}

}
