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

import beans.UserProfilesBeanLocal;
import beans.UsersBeanLocal;
import domain.User;
import domain.UserProfile;

@Path("/user")
public class RestUser {
	@EJB private UsersBeanLocal userejb;
	@EJB private UserProfilesBeanLocal profileejb;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/readid/{key}")
	public User getUserById(@PathParam("key") long key) {
		User user = null;
		Optional<User> opt = userejb.read(key);
		if (opt.isPresent()) {
			user = opt.get();
		}
		return user;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/read/{email}")
	public User getUserByEmail(@PathParam("email") String email) {
		User user = null;
		Optional<User> opt = userejb.read(email);
		if (opt.isPresent()) {
			user = opt.get();
		}
		return user;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/search/{search}")
	public List<User> searchUsers(@PathParam("search") String search) {
		return userejb.searchUsers(search);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/members/{organization}")
	public List<User> listMembers(@PathParam("organization") String organization) {
		return userejb.listMembers(organization);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("")
	public boolean create(User user) {
		userejb.create(user);
		return true;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("")
	public boolean update(User user) {
		userejb.update(user);
		return true;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("")
	public boolean updateProfile(UserProfile user) {
		profileejb.update(user);
		return true;
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("delete/{key}")
	public boolean delete(@PathParam("key") long key) {
		User user = new User();
		user.setUserid(key);
		userejb.delete(user);
		return true;
	}

}
