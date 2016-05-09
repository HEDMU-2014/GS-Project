package beans;

import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.Rating;
import entities.Ratings;

/**
 * Session Bean implementation class RatingsBean
 */
@Stateless
public class RatingsBean implements RatingsBeanLocal {
	@PersistenceContext private EntityManager em;

	@Override
	public Optional<Rating> readRating(InterestSpaceUserPK key) {
		Optional<Rating> opt = Optional.empty();
		Ratings intCon = em.find(Ratings.class, key); 
		if (intCon != null) {
			opt = Optional.of(intCon.map(new Rating()));
		}
		return opt;
	}
	
	@Override
	public void createRating(Rating key) {
		Ratings entity = new Ratings(key);
		em.persist(entity);
	}
	
	@Override
	public void updateRating(Rating key) {
		Ratings entity = em.find(Ratings.class, key); 
		if (entity != null) {
			entity.update(key);
		} else {
			throw new RuntimeException("Rating with id " + key + " not found");
		}
	}
	
	@Override
	public void deleteRating(Rating key) {
		Ratings entity = em.find(Ratings.class, key); 
		if (entity != null) {
			em.remove(entity);
		} else {
			throw new RuntimeException("Rating with id " + key + " not found");
		}
	}



}
