package entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import domain.LoginType;
import domain.Role;
import domain.User;

@Entity
@NamedQueries({
		@NamedQuery(name = "getUserFromEmail", 
				query = "SELECT u FROM Users u " + "WHERE UPPER(u.email) = :email "),
		@NamedQuery(name = "listMembers", 
				query = "SELECT u FROM Users u, IN (u.roles) r " 
						+ "WHERE r.role = 'Member' "
						+ "AND u.userprofile.organization.name LIKE :organization") 
		})

public class Users implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userid;
	@Column(unique = true)
	private String email;
	private String password;
	private Timestamp lastlogin;
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE} )
	@PrimaryKeyJoinColumn(name = "userid", referencedColumnName = "userid")
	private UserProfiles userprofile;
	@ManyToOne
	@JoinColumn(name = "logintype", referencedColumnName = "id")
	private LoginTypes logintype;
	@ManyToMany
	@JoinTable(name = "AssignedRoles", joinColumns = @JoinColumn(name = "userid", referencedColumnName = "userid") , inverseJoinColumns = @JoinColumn(name = "role", referencedColumnName = "roleid") )
	private Collection<Roles> roles;

	public Users() {
		super();
	}

	public Users(User user) {
		super();
		update(user);
	}

	public Users update(User user) {
		this.userid = user.getUserid();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.userprofile = new UserProfiles();
		this.userprofile.setUserid(user.getUserid());
		this.userprofile.setUser(this);
		this.logintype = new LoginTypes(user.getLogintype());
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
		user.setLogintype(logintype.map(new LoginType()));
		user.setRoles(new ArrayList<>());
		for (Roles role : roles) {
			user.getRoles().add(role.map(new Role()));
		}
		return user;
	}

	public long getUserid() {
		return this.userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
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

	public UserProfiles getUserprofile() {
		return userprofile;
	}

	public void setUserprofile(UserProfiles userprofile) {
		this.userprofile = userprofile;
	}

	public LoginTypes getLogintype() {
		return logintype;
	}

	public void setLogintype(LoginTypes logintype) {
		this.logintype = logintype;
	}

	public Collection<Roles> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Roles> roles) {
		this.roles = roles;
	}

}
