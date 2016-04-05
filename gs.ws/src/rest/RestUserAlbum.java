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

import beans.UserAlbumBeanLocal;
import domain.Picture;
import domain.UserAlbum;

@Path("/useralbum")
public class RestUserAlbum {
	@EJB private UserAlbumBeanLocal ejb;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/search/{key}")
	public List<UserAlbum> searchUserAlbums(@PathParam("key") String key) {
		
		return ejb.searchUserAlbums(key);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/readid/{key}")
	public UserAlbum getUserAlbumById(@PathParam("key") long key) {
		UserAlbum userAlbum = null;
		Optional<UserAlbum> opt = ejb.getUserAlbum(key);
		if (opt.isPresent()) {
			userAlbum = opt.get();
		}
		return userAlbum;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getcover/{key}")
	public Picture getCoverPictureById(@PathParam("key") long key) {
		Picture picture = null;
		Optional<UserAlbum> opt = ejb.getUserAlbum(key);
		if (opt.isPresent()) {
			picture = opt.get().getCoverPicture();
		}
		return picture;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("")
	public boolean createUserAlbum(UserAlbum userAlbum) {
		ejb.createUserAlbum(userAlbum);
		return true;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("")
	public boolean updateUserAlbum(UserAlbum userAlbum) {
		ejb.updateUserAlbum(userAlbum);
		return true;
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("delete/{key}")
	public boolean deleteUserAlbum(@PathParam("key") long key) {
		UserAlbum userAlbum = new UserAlbum();
		userAlbum.setAlbumId(key);
		ejb.deleteUserAlbum(userAlbum);
		return true;
	}

}
