package gs.ejb.beans;

import java.util.Optional;

import javax.ejb.Local;

import gs.ejb.domain.Place;

@Remote
public interface PlaceRemote {

    Optional<Place> getPlace(String placeid);

    void createPlace(Place place);

    void updatePlace(Place place);

    void deletePlace(Place place);

}
