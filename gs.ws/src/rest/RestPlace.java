package rest;

import beans.PlaceBeanLocal;
import domain.Place;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Optional;


@Path("/place")
public class RestPlace {

    @EJB
    private PlaceBeanLocal ejb;

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public boolean createPlace(Place place) {
        ejb.createPlace(place);
        return true;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("readid/{key}")
    public Place readPlace(@PathParam("key") int key) {
        Place place = new Place();
        Optional<Place> opt = ejb.readPlace(key);
        if (opt.isPresent()) place = opt.get();
        return place;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public boolean updatePlace(Place place) {
        ejb.updatePlace(place);
        return true;
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("delete/{key}")
    public boolean deletePlace(@PathParam("key") int key) {
        Place place = new Place();
        place.setPlaceId(key);
        ejb.deletePlace(key);
        return true;
    }
}
