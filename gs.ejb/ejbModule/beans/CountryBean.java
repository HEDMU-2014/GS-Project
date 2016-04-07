package beans;

import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.Country;
import entities.Countries;

/**
 * Session Bean implementation class CountryBean
 */
@Stateless
public class CountryBean implements CountryRemote, CountryLocal {
	@PersistenceContext private EntityManager em;
	
	

	
	
	@Override
	public Optional<Country> getCountry(String countrycode) {
		Countries country = em.find(Countries.class, countrycode); 
		if (country != null) {
			return Optional.of(country.map(new Country()));
		} else {
			return Optional.empty();
		}
	}
	
	@Override
	public void createCountry(Country country) {
		Countries entity = new Countries(country);
		em.persist(entity);
	}
	
	@Override
	public void updateCountry(Country country) {
		Countries countries = em.find(Countries.class, country.getCountrycode()); 
		if (countries != null) {
			countries.update(country);
		} else {
			throw new RuntimeException("Country with code " + country.getCountrycode() + " not found");
		}
	}
	
	@Override
	public void deleteCountry(Country country) {
		Countries countries = em.find(Countries.class, country.getCountrycode()); 
		if (countries != null) {
			em.remove(countries);
		} else {
			throw new RuntimeException("Country with code " + country.getCountrycode() + " not found");
		}
	}



}
