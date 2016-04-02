package rest;

import java.util.Optional;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.UsersBeanLocal;
import domain.User;

@Path("/user")
public class RestUser {
	@EJB private UsersBeanLocal ejb;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/read/{key}")
	public User getUser(@PathParam("key") String key) {
		User user = null;
		Optional<User> opt = ejb.read(key);
		if (opt.isPresent()) {
			user = opt.get();
		}
		return user;
	}

}
