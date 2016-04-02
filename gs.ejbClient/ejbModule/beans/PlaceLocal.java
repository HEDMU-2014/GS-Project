package beans;

import java.util.Optional;

import javax.ejb.Local;

import domain.Place;

@Local
public interface PlaceLocal {

    Optional<Place> getPlace(int placeid);

    void createPlace(Place place);

    void updatePlace(Place place);

    void deletePlace(Place place);

}