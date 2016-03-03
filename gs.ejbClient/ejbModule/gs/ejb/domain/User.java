package gs.ejb.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private int userid;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private LocalDateTime createddate;
	private LocalDateTime lastlogin;
	private Organization organization;
	private Collection<Role> roles;
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getFirstname() {
		return firstname;
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
	public LocalDateTime getCreateddate() {
		return createddate;
	}
	public void setCreateddate(LocalDateTime createddate) {
		this.createddate = createddate;
	}
	public LocalDateTime getLastlogin() {
		return lastlogin;
	}
	public void setLastlogin(LocalDateTime lastlogin) {
		this.lastlogin = lastlogin;
	}
	public Organization getOrganization() {
		return organization;
	}
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	public Collection<Role> getRoles() {
		return roles;
	}
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", password=" + password + ", createddate=" + createddate + ", lastlogin=" + lastlogin
				+ ", organization=" + organization + ", roles=" + roles + "]";
	}

}
