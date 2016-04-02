package gs.ejb.beans;

import java.util.Optional;

import javax.ejb.Local;

import gs.ejb.domain.Country;

@Local
public interface CountryLocal {

	Optional<Country> getCountry(String countrycode);

	void createCountry(Country country);

	void updateCountry(Country country);

	void deleteCountry(Country country);

}
