package beans;

import java.util.List;
import java.util.Optional;

import javax.ejb.Local;

import domain.Country;

@Local
public interface CountryLocal {

	Optional<Country> getCountry(String countrycode);

	void createCountry(Country country);

	void updateCountry(Country country);

	void deleteCountry(Country country);
	List<Country> allCountries();
}
