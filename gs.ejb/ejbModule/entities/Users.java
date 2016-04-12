package entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import domain.Role;
import domain.User;

@Entity
@NamedQueries({
	@NamedQuery(name = "getUserFromEmail", 
		query = "SELECT u FROM Users u "
			+ "WHERE UPPER(u.email) = :email "),
	@NamedQuery(name = "searchUsers", 
	query = "SELECT u FROM Users u, UserProfiles p "
		+ "WHERE UPPER(p.firstname) LIKE :search "
		+ "OR UPPER(p.lastname) LIKE :search "
		+ "OR UPPER(u.email) LIKE :search "
		+ "OR UPPER(p.organization.name) LIKE :search "
		+ "ORDER BY p.lastname"),
	@NamedQuery(name = "listMembers", 
		query = "SELECT u FROM Users u, UserProfiles p, IN (u.roles) r "
			+ "WHERE r.role = 'Member' " 
			+ "AND p.organization.name LIKE :organization")})

public class Users implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userid;
	private String email;
	private String password;
	private Timestamp lastlogin;
	
	@ManyToMany
	@JoinTable(name = "AssignedRoles",
	joinColumns = @JoinColumn(name = "userid", referencedColumnName = "userid") ,
	inverseJoinColumns = @JoinColumn(name = "role", referencedColumnName = "roleid") )
	private Collection<Roles> roles;

	public Users() {
		super();
	}
	
	public Users(User user) {
		update(user);
	}
	
	public Users update(User user) {
		this.userid = user.getUserid();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.lastlogin = new Timestamp(user.getLastlogin().getTimeInMillis());
		this.roles = new ArrayList<>();
		for (Role role : user.getRoles()) {
			this.roles.add(new Roles(role));
		}
		return this;
	}
	
	public User map(User user) {
		user.setUserid(userid);
		user.setEmail(email);
		user.setPassword(password);
		user.setLastlogin(Calendar.getInstance());
		user.getLastlogin().setTimeInMillis(lastlogin.getTime());
		user.setRoles(new ArrayList<>());
		for (Roles role : roles) {
			user.getRoles().add(role.map(new Role()));
		}
		return user;
	}

	public long getUserid() {
		return this.userid;
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


	public Timestamp getLastlogin() {
		return lastlogin;
	}

	public void setLastlogin(Timestamp lastlogin) {
		this.lastlogin = lastlogin;
	}

	public Collection<Roles> getRoles() {
		return roles;
	}
	
}
