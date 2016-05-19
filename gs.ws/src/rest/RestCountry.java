package rest;

import java.util.List;
import java.util.Optional;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.CountryLocal;
import domain.Country;

@Path("/country")
public class RestCountry {
	@EJB private CountryLocal ejb;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/read/{key}")
	public Country getCountry(@PathParam("key") String key) {
		Country country = null;
		Optional<Country> opt = ejb.getCountry(key);
		if (opt.isPresent()) {
			country = opt.get();
		}
		return country;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/all")
	public List<Country> allCountries() {
		return ejb.allCountries();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("")
	public boolean create(Country country) {
		ejb.createCountry(country);
		return true;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("")
	public boolean update(Country country) {
		ejb.updateCountry(country);
		return true;
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("delete/{key}")
	public boolean delete(@PathParam("key") String key) {
		Country country = new Country();
		country.setCountrycode(key);
		ejb.deleteCountry(country);
		return true;
	}

}
