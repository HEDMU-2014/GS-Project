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

import beans.LoginTypesBeanLocal;
import domain.LoginType;

@Path("/login")
public class RestLoginTypes {
	@EJB private LoginTypesBeanLocal ejb;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/read/{key}")
	public LoginType get(@PathParam("key") int key) {
		LoginType login = null;
		Optional<LoginType> opt = ejb.read(key);
		if (opt.isPresent()) {
			login = opt.get();
		}
		return login;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/all")
	public List<LoginType> all() {
		return ejb.allLoginTypes();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("")
	public boolean create(LoginType login) {
		ejb.create(login);
		return true;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("")
	public boolean update(LoginType login) {
		ejb.update(login);
		return true;
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("delete/{key}")
	public boolean delete(@PathParam("key") int key) {
		LoginType login = new LoginType();
		login.setId(key);
		ejb.delete(login);
		return true;
	}

}
