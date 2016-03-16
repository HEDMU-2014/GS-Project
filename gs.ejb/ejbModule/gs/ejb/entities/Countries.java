package gs.ejb.entities;

import java.io.Serializable;
import javax.persistence.*;

import gs.ejb.domain.Country;

/**
 * Entity implementation class for Entity: Country
 *
 */
@Entity

public class Countries implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(length=2, nullable=false, unique=true)
	private String countrycode;
	
	@Column(length=50, nullable=false, unique=true)
	private String countryname;
	
	public Countries() {
		super();
	}
	
	public Countries(Country country){
		update(country);
	}
   
	public Countries update(Country country){
		this.countrycode = country.getCountrycode();
		this.countryname = country.getCountryname();
		return this;
	}
	
	public Country map(Country country){
		country.setCountrycode(this.countrycode);
		country.setCountryname(this.countryname);
		return country;
	}
	
	public String getCountrycode(){
		return this.countrycode;
	}
	
	public void setCountrycode(String countrycode){
		this.countrycode = countrycode;
	}
	
	public String getCountryname(){
		return this.countryname;
	}
	
	public void setCountryname(String countryname){
		this.countryname = countryname;
	}
	
	@Override
	public String toString(){
		return "Country [countrycode=" + countrycode + ", countryname=" + countryname + "]";
	}
	
}
