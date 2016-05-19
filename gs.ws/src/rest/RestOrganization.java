package rest;

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

import beans.OrganizationBeanLocal;
import domain.Organization;

@Path("/org")
public class RestOrganization {
	@EJB private OrganizationBeanLocal ejb;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/read/{key}")
	public Organization get(@PathParam("key") int key) {
		Organization org = null;
		Optional<Organization> opt = ejb.getOrganization(key);
		if (opt.isPresent()) {
			org = opt.get();
		}
		return org;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("")
	public boolean create(Organization org) {
		ejb.createOrganization(org);
		return true;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("")
	public boolean update(Organization org) {
		ejb.updateOrganization(org);
		return true;
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("delete/{key}")
	public boolean delete(@PathParam("key") int key) {
		Organization org = new Organization();
		org.setOrgId(key);
		ejb.deleteOrganization(org);
		return true;
	}

}
