package beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.InterestSpaceUserPK;
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
		Ratings ratings = em.find(Ratings.class, key); 
		if (ratings != null) {
			opt = Optional.of(ratings.map(new Rating()));
		}
		return opt;
	}
	
	@Override
	public void createRating(Rating domain) {
		Ratings entity = new Ratings(domain);
		em.persist(entity);
	}
	
	@Override
	public void updateRating(Rating domain) {
		InterestSpaceUserPK key = new InterestSpaceUserPK(domain.getUser().getUserid(), domain.getPlace().getPlaceId(), domain.getInterest().getInterestId());
		Ratings entity = em.find(Ratings.class, key); 
		if (entity != null) {
			entity.update(domain);
		} else {
			throw new RuntimeException("Rating with id " + key + " not found");
		}
	}
	
	@Override
	public void deleteRating(Rating domain) {
		InterestSpaceUserPK key = new InterestSpaceUserPK(domain.getUser().getUserid(), domain.getPlace().getPlaceId(), domain.getInterest().getInterestId());
		Ratings entity = em.find(Ratings.class, key); 
		if (entity != null) {
			em.remove(entity);
		} else {
			throw new RuntimeException("Rating with id " + key + " not found");
		}
	}

	@Override
	public List<Rating> listRatingsForUser(long userid) {
		List<Rating> ratings = new ArrayList<>();
		List<Ratings> ratingse = em.createNamedQuery("listRatingsForUser", Ratings.class)
				.setParameter("userid", userid)
				.getResultList();
		for (Ratings r : ratingse) {
			ratings.add(r.map(new Rating()));
		}
		return ratings;
	}



}
