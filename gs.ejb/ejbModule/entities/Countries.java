package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import domain.Country;

/**
 * Entity implementation class for Entity: Country
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "allCountries", 
			query = "SELECT c FROM Countries c ")
})

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
	
	public Countries setCountrycode(String countrycode){
		this.countrycode = countrycode;
		return this;
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
