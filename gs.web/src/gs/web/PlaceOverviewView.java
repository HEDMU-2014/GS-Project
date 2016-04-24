package gs.web;

import beans.PlaceBeanLocal;
import domain.Place;
import org.jboss.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class PlaceOverviewView implements Serializable {

    private static final long serialVersionUID = 1L;
    @EJB
    private PlaceBeanLocal ejb;
    private Logger logger = Logger.getLogger(this.getClass());
    private String searchstring;
    private List<PlaceWrapper> places;
    private PlaceWrapper selectedPlace;

    @PostConstruct
    public void init() {}

    public void search() {
        logger.info("Search : " + searchstring);
        List<Place> places = ejb.searchPlaces(searchstring);
        this.places = new ArrayList<>();
        int i = 0;
        for (Place place : places) {
            PlaceWrapper pw = new PlaceWrapper();
            pw.setId(i++);
            pw.setPlace(place);
            this.places.add(pw);
        }
    }

    public String view() {
        logger.info("Selected user : " + selectedPlace);
        return null;
    }

    public String update() {
        logger.info("Selected user : " + selectedPlace);
        return null;
    }

    public String create() {
        return null;
    }

    public String getSearchstring() {
        return searchstring;
    }

    public void setSearchstring(String searchstring) {
        this.searchstring = searchstring;
    }

    public List<PlaceWrapper> getPlaces() {
        return places;
    }

    public void setPlaces(List<PlaceWrapper> places) {
        this.places = places;
    }

    public PlaceWrapper getSelectedPlace() {
        return selectedPlace;
    }

    public void setSelectedPlace(PlaceWrapper selectedPlace) {
        this.selectedPlace = selectedPlace;
    }
}
