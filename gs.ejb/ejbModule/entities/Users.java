package entities;

import java.io.Serializable;
import java.sql.Timestamp;
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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import domain.Organization;
import domain.Role;
import domain.User;

/**
 * Entity implementation class for Entity: Users
 *
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "getUserFromEmail", query = "SELECT u FROM Users u " + "WHERE UPPER(u.email) = :email "),
		@NamedQuery(name = "searchUsers", query = "SELECT u FROM Users u WHERE UPPER(u.firstName) LIKE :search OR UPPER(u.lastName) LIKE :search OR UPPER(u.email) LIKE :search OR UPPER(u.organization.name) LIKE :search ORDER BY u.lastName"),
		@NamedQuery(name = "listMembers", query = "SELECT u FROM Users u, IN (u.roles) r WHERE UPPER(r.role) = UPPER('Member') AND u.organization.name LIKE :organization") })

public class Users implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userID;
	private int roleID;
	@Column(length = 50, nullable = false)
	private String firstName;
	@Column(length = 50, nullable = false)
	private String lastName;
	@Column(length = 50, nullable = false, unique = true)
	// @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\." +
	// "[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
	// + "(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9]"
	// + "(?:[a-z0-9-]*[a-z0-9])?", message = "{invalid.email}")
	private String email;
	@Column(length = 50, nullable = false)
	private String password;
	private Timestamp createdDate;
	private Timestamp lastLogin;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "organization")
	private Organizations organization;

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
		this.organization = new Organizations(user.getOrganization());
		this.setPassword(user.getPassword());
		this.setUserID(user.getUserid());
		this.setRoles(new ArrayList<Roles>());
		for (Role r : user.getRoles())
			this.getRoles().add(new Roles(r));
		return this;
	}

	public long getUserID() {
		return this.userID;
	}

	public void setUserID(long userID) {
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

	public Organizations getOrganization() {
		return organization;
	}
	public void setOrganization(Organizations organization) {
		this.organization = organization;
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
		domUser.setOrganization(organization.map(new Organization()));
		domUser.setLastlogin(this.lastLogin.toLocalDateTime());
		domUser.setRoles(new ArrayList<Role>());
		for (Roles r : this.getRoles())
			domUser.getRoles().add(r.getDomRole(new Role()));
		return domUser;
	}

}
