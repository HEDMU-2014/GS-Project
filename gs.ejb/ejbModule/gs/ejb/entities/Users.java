package gs.ejb.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

import gs.ejb.domain.Role;
import gs.ejb.domain.User;

/**
 * Entity implementation class for Entity: Users
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "searchUsers", 
		query = "SELECT u FROM Users u "
			+ "WHERE UPPER(u.firstname) LIKE :search "
			+ "OR UPPER(u.lastname) LIKE :search "
			+ "OR UPPER(u.email) LIKE :search "
			+ "ORDER BY u.lastname"),
	@NamedQuery(name = "listMembers", 
		query = "SELECT u FROM Users u, IN (u.roles) r "
			+ "WHERE r.role = 'Member'")})

public class Users implements Serializable {
	private static final long serialVersionUID = 1L;

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userid;
	
	@Column(length=50, nullable=false)
	private String firstname;
	
	@Column(length=50, nullable=false)
	private String lastname;
	
	@Column(length=50, nullable=false, unique=true)
	private String email;
	
	@Column(length=50, nullable=false)
	private String password;
	
	@NotNull
	private Timestamp createddate;
	
	private Timestamp lastlogin;
	
	@Column(length=50, nullable=false)
	private String organization;
	
	@ManyToMany
	@JoinTable(name = "AssignedRoles", joinColumns=
	@JoinColumn(name="userid", referencedColumnName="userid"),
	inverseJoinColumns=
	@JoinColumn(name="role", referencedColumnName="roleid"))
	private Collection<Roles> roles;
	
	public Users() {
		super();
	}  
	
	public Users(User user) {
		update(user);
	}
	
	public Users update(User user) {
		this.firstname = user.getFirstname();
		this.lastname = user.getLastname();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.organization = user.getOrganization();
		this.createddate = Timestamp.valueOf(user.getCreateddate());
		this.lastlogin = Timestamp.valueOf(user.getLastlogin());
		this.roles = new ArrayList<>();
		for (Role role : user.getRoles()) {
			this.roles.add(new Roles(role));
		}
		return this;
	}
	public User map(User user) {
		user.setUserid(userid);
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setEmail(email);
		user.setPassword(password);
		user.setOrganization(organization);
		user.setCreateddate(createddate.toLocalDateTime());
		user.setLastlogin(lastlogin.toLocalDateTime());
		user.setRoles(new ArrayList<>());
		for (Roles role : roles) {
			user.getRoles().add(new Role(role.getRoleid(), role.getRole()));
		}
		return user;
	}
	
	public int getUserid() {
		return this.userid;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
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
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public Timestamp getCreateddate() {
		return createddate;
	}
	public void setCreateddate(Timestamp createddate) {
		this.createddate = createddate;
	}
	public Timestamp getLastlogin() {
		return lastlogin;
	}
	public void setLastlogin(Timestamp lastlogin) {
		this.lastlogin = lastlogin;
	}

	public Collection<Roles> getRoles() {
		return roles;
	}

	@Override
	public String toString() {
		return "Users [userid=" + userid + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", password=" + password + ", createddate=" + createddate + ", lastlogin=" + lastlogin
				+ ", organization=" + organization + ", roles=" + roles + "]";
	}
   
}
