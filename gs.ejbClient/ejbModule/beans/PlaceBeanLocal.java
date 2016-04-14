package beans;

import java.util.Optional;

import javax.ejb.Local;

import domain.Place;

@Local
public interface PlaceBeanLocal {

    Optional<Place> readPlace(int placeid);

    void createPlace(Place place);

    void updatePlace(Place place);

    void deletePlace(int placeid);

}