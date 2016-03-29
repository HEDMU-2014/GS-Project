package gs.ejb.beans;


import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import gs.ejb.domain.Place;
import gs.ejb.entities.Places;

@Stateless
public class PlaceBean implements PlaceRemote, PlaceLocal {
    @PersistenceContext private EntityManager em;

    @Override
    public Optional<Place> getPlace(int placeId) {
        Places places = em.find(Places.class, placeId);
        if (places != null) {
            return Optional.of(places.map(new Place()));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void createPlace(Place place) {
        Places entity = new Places(place);
        em.persist(entity);
    }

    @Override
    public void updatePlace(Place place) {
        Places places = em.find(Places.class, place.getPlaceId());
        if (places != null) {
            places.update(place);
        } else {
            throw new RuntimeException("Place with id " + place.getPlaceId() + " not found");
        }
    }

    @Override
    public void deletePlace(Place place) {
        Places places = em.find(Places.class, place.getPlaceId());
        if (places != null) {
            em.remove(places);
        } else {
            throw new RuntimeException("Place with id " + place.getPlaceId() + " not found");
        }
    }
}
