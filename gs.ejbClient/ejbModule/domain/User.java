package domain;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;


public class User {

	private long userid;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private Calendar createddate;
	private Calendar lastlogin;
	private Organization organization;
	private Collection<Role> roles;

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
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

	public Calendar getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Calendar createddate) {
		this.createddate = createddate;
	}

	public Calendar getLastlogin() {
		return lastlogin;
	}

	public void setLastlogin(Calendar lastlogin) {
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
		SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd-HH:mm:ss" );
		return "User [userid=" + userid + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", password=" + password + ", createddate=" + formatter.format(createddate.getTime()) 
				+ ", lastlogin=" + formatter.format(lastlogin.getTime()) 
				+ ", organization=" + organization + ", roles=" + roles + "]";
	}
	
}
