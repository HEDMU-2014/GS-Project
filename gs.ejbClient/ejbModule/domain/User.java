package domain;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;


public class User {

	private long userid;
	private String email;
	private String password;
	private Calendar lastlogin;
	private LoginType logintype;
	private Collection<Role> roles;

	public long getUserid() {
		return userid;
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

	public Calendar getLastlogin() {
		return lastlogin;
	}

	public void setLastlogin(Calendar lastlogin) {
		this.lastlogin = lastlogin;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	
	public LoginType getLogintype() {
		return logintype;
	}

	public void setLogintype(LoginType logintype) {
		this.logintype = logintype;
	}

	@Override
	public String toString() {
		SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd-HH:mm:ss" );
		return "User [userid=" + userid + ", email=" + email + ", password=" + password 
				+ ", lastlogin=" + formatter.format(lastlogin.getTime()) 
				+ ", logintype=" + logintype + ", roles=" + roles + "]";
	}


}
