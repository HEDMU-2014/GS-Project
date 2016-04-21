package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import domain.Organization;

/**
 * Entity implementation class for Entity: Organizations
 *
 */
@Entity

public class Organizations implements Serializable {
	private static final long serialVersionUID = 1L;

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int orgId;
	
	@Column(length=50, nullable=false)
	private String name;
	
	@Column(length=50, nullable=false)
	private String address;

	private int zip;
	
	@Column(length=50, nullable=false)
	private String city;

	public Organizations() {
		super();
	} 
	
	public Organizations(Organization org) {
		this.orgId = org.getOrgId();
		update(org);
	} 
	
	public Organizations update(Organization org) {
		this.name = org.getName();
		this.address = org.getAddress();
		this.zip = org.getZip();
		this.city = org.getCity();
		return this;
	}
	public Organization map(Organization org) {
		org.setOrgId(orgId);
		org.setName(name);
		org.setAddress(address);
		org.setZip(zip);
		org.setCity(city);
		return org;
	}

	public int getOrgId() {
		return this.orgId;
	}

	public Organizations setOrgId(int orgId) {
		this.orgId = orgId;
		return this;
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}   
	public int getZip() {
		return this.zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}   
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}
   
}
