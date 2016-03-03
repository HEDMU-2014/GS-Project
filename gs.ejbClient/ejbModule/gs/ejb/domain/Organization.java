package gs.ejb.domain;

import java.io.Serializable;

public class Organization implements Serializable {
	private static final long serialVersionUID = 1L;

	   
	private int OrgId;
	private String name;
	private String address;
	private int zip;
	private String city;

	public int getOrgId() {
		return this.OrgId;
	}

	public void setOrgId(int OrgId) {
		this.OrgId = OrgId;
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

	@Override
	public String toString() {
		return "Organization [OrgId=" + OrgId + ", name=" + name + ", address=" + address + ", zip=" + zip + ", city="
				+ city + "]";
	}
   
}
