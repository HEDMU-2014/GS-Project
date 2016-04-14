package beans;

import java.util.Optional;

import javax.ejb.Remote;

import domain.Place;

@Remote
public interface PlaceBeanRemote {

    Optional<Place> readPlace(int placeid);

    void createPlace(Place place);

    void updatePlace(Place place);

    void deletePlace(int placeid);

}
