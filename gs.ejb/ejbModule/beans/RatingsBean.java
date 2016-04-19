package beans;

import javax.ejb.Stateless;
import java.util.Optional;

import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.Rating;
import entities.Ratings;

/**
 * Session Bean implementation class RatingsBean
 */
@Stateless
@LocalBean
public class RatingsBean implements RatingsBeanRemote, RatingsBeanLocal {

	@PersistenceContext EntityManager em;
	
    public void create(Rating rating) {
        Ratings entity = new Ratings(rating);
        em.persist(entity);
    }

	public Optional<Rating> read(int rating) {
		Ratings readRating = em.find(Ratings.class, rating);
		if (readRating != null) {
			return Optional.of(readRating.map(new Rating()));
		} else {
			return Optional.empty();
		}
	}

	public void update(Rating rating) {
		Ratings ratings = em.find(Ratings.class, rating.getRating());
		if (ratings != null) {
			ratings.update(rating);
		} else {
			throw new RuntimeException("Rating with a number of " + rating.getRating() + " not found");
		}
	}

	public void delete(Rating rating) {
		Ratings ratings = em.find(Ratings.class, rating.getRating());
		if (ratings != null) {
			em.remove(ratings);
		} else {
			throw new RuntimeException("Rating with a number of " + rating.getRating() + " not found");
		}
	}

}
