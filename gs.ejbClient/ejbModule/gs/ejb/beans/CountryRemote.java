package gs.ejb.beans;

import java.util.Optional;

import javax.ejb.Remote;

import gs.ejb.domain.Country;

@Remote
public interface CountryRemote {

	Optional<Country> getCountry(String countrycode);

	void createCountry(Country country);

	void updateCountry(Country country);

	void deleteCountry(Country country);

}
