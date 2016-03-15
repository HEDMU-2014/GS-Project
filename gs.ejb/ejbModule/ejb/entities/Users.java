package ejb.entities;

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
import javax.validation.constraints.NotNull;

import ejb.domain.Role;
import ejb.domain.User;

/**
 * Entity implementation class for Entity: Users
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "getUserFromEmail", 
			query = "SELECT u FROM Users u "
					+ "WHERE UPPER(u.email) = :email "),
	@NamedQuery(name = "searchUsers",
			query = "SELECT u FROM Users u "
					+ "WHERE UPPER(u.firstName) LIKE :search "
					+ "OR UPPER(u.lastName) LIKE :search "
					+ "OR UPPER(u.email) LIKE :search "
					+ "OR UPPER(u.organization.name) LIKE :search "
					+ "ORDER BY u.lastName"),
	@NamedQuery(name = "listMembers", 
			query = "SELECT u FROM Users u, IN (u.roles) r "
					+ "WHERE r.role = 'Member' " 
					+ "AND u.organization.name LIKE :organization")
})

public class Users implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long userid;
	
	@Column(nullable=false, length=50)
	private String firstName;
	
	@Column(nullable=false, length=50)
	private String lastName;
	
	@Column(nullable=false, unique=true, length=50)
	private String email;
	
	@Column(nullable=false, length=128)
	private String password;
	
	@NotNull
	private Timestamp createdDate;
	
	private Timestamp lastLogin;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="AssignedRoles",
			joinColumns=@JoinColumn(name="userid", referencedColumnName="userid"),
			inverseJoinColumns=@JoinColumn(name="roleid", referencedColumnName="roleid"))
	private Collection<Roles> roles;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="organization")
	private Organizations organization;

	public Users() {
		super();
	}
	
	public Users(User user) {
		update(user);
	}
	
	public Users update(User user) {
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.createdDate = user.getCreatedDate();
		this.lastLogin = user.getLastLogin();
		this.roles = new ArrayList<>();
		for(Role role : user.getRoles())
			this.roles.add(new Roles(role));
		return this;
		
	}
	
	public User map(User user) {
		user.setUserid(userid);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setPassword(password);
		user.setCreatedDate(createdDate);
		user.setLastLogin(lastLogin);
		user.setRoles(new ArrayList<>());
		for (Roles role : roles)
			user.getRoles().add(role.map(new Role()));
		return user;
		
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Collection<Roles> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Roles> roles) {
		this.roles = roles;
	}

	public Organizations getOrganization() {
		return organization;
	}

	public void setOrganization(Organizations organization) {
		this.organization = organization;
	}
   
}
