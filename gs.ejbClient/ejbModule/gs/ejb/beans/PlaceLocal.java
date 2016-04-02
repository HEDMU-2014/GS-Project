package gs.ejb.beans;

import java.util.Optional;

import javax.ejb.Local;

import gs.ejb.domain.Place;

@Local
public interface PlaceLocal {

    Optional<Place> getPlace(String placeid);

    void createPlace(Place place);

    void updatePlace(Place place);

    void deletePlace(Place place);

}