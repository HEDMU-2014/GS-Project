package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import domain.LoginType;

/**
 * Entity implementation class for Entity: LoginType
 *
 */
@Entity

public class LoginTypes implements Serializable {

	@Id
	private int id;
	private String name;
	private static final long serialVersionUID = 1L;

	
	public LoginTypes() {
		super();
	}  
	
	public LoginTypes(LoginType logintype) {
		super();
		update(logintype);
	}
	   
	public LoginTypes update(LoginType logintype) {
		this.id = logintype.getId();
		this.name = logintype.getName();
		return this;
	}
	
	public LoginType map(LoginType logintype) {
		logintype.setId(this.id);
		logintype.setName(this.name);
		return logintype;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
   
}
