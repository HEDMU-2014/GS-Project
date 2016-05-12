package gs.web;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named()
@SessionScoped
public class PlaceOverviewModel implements Serializable {

    private static final long serialVersionUID = 1L;
    private String searchstring;
    private List<PlaceWrapper> places;
    private PlaceWrapper selectedPlace;

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
