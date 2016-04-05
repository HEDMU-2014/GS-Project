package beans;

import java.util.Optional;

import javax.ejb.Remote;

import domain.Place;

@Remote
public interface PlaceRemote {

    Optional<Place> getPlace(int placeid);

    void createPlace(Place place);

    void updatePlace(Place place);

    void deletePlace(Place place);

}
