package gs.web;

import domain.Place;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named()
@SessionScoped
public class PlaceDetailModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private Place place;
    private boolean editable;

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public boolean isNotEdit() {
        return !editable;
    }

    public boolean isShowCreate() {
        return editable && place.getPlaceId() == 0;
    }
    public boolean isShowUpdate() {
        return editable && place.getPlaceId() > 0;
    }
    public boolean isShowDelete() {
        return place.getPlaceId() > 0;
    }
}
