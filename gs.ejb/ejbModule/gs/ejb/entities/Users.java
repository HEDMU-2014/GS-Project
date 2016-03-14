package gs.ejb.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Pattern;

import gs.ejb.domain.Role;
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
	@Column(length = 50, nullable = false)
	private String firstName;
	@Column(length = 50, nullable = false)
	private String lastName;
	@Column(length = 50, nullable = false, unique = true)
	@Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\." + "[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
			+ "(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9]"
			+ "(?:[a-z0-9-]*[a-z0-9])?", message = "{invalid.email}")
	private String email;
	@Column(length = 50, nullable = false)
	private String password;
	private Timestamp createdDate;
	private Timestamp lastLogin;
	private String organisation;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "AssignedRoles", joinColumns = @JoinColumn(name = "userid", referencedColumnName = "userid") , inverseJoinColumns = @JoinColumn(name = "role", referencedColumnName = "roleid") )
	private Collection<Roles> roles;

	private static final long serialVersionUID = 1L;

	public Users() {
	}

	public Users(User user) {
		getEntityUsers(user);
	}

	public Users getEntityUsers(User user) {
		this.setCreatedDate(Timestamp.valueOf(user.getCreateddate()));
		this.setEmail(user.getEmail());
		this.setFirstName(user.getFirstname());
		this.setLastLogin(Timestamp.valueOf(user.getLastlogin()));
		this.setLastName(user.getLastname());
		this.setOrganisation(user.getOrganization());
		this.setPassword(user.getPassword());
		this.setUserID(user.getUserid());
		this.setRoles(new ArrayList<Roles>());
		for (Role r : user.getRoles())
			this.getRoles().add(new Roles(r));
		return this;
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

	public Timestamp getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getLastLogin() {
		return this.lastLogin;
	}

	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getOrganisation() {
		return this.organisation;
	}

	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}

	public Collection<Roles> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Roles> roles) {
		this.roles = roles;
	}

	public User getDomUser(User domUser) {
		domUser.setUserid(this.userID);
		domUser.setFirstname(this.firstName);
		domUser.setLastname(this.lastName);
		domUser.setPassword(this.password);
		domUser.setCreateddate(this.createdDate.toLocalDateTime());
		domUser.setEmail(this.email);
		domUser.setOrganization(this.organisation);
		domUser.setLastlogin(this.lastLogin.toLocalDateTime());
		domUser.setRoles(new ArrayList<Role>());
		for (Roles r : this.getRoles())
			domUser.getRoles().add(r.getDomRole(new Role()));
		return domUser;
	}

}
