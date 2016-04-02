package gs.ejb.domain;

import java.io.Serializable;

public class Country implements Serializable {
	private static final long serialVersionUID = 1L;

	private String countrycode;
	private String countryname;
	
	public Country() {
		
	}
	
	public Country(String countrycode, String countryname) {
		this.countrycode = countrycode;
		this.countryname = countryname;
	}

	public String getCountrycode() {
		return countrycode;
	}
	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}
	public String getCountryname() {
		return countryname;
	}
	public void setCountryname(String countryname) {
		this.countryname = countryname;
	}
	@Override
	public String toString() {
		return "Country [countrycode=" + countrycode + ", countryname=" + countryname + "]";
	}

}
