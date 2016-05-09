package beans;

import java.util.Optional;

import javax.ejb.Local;

import domain.Rating;

@Local
public interface RatingsBeanLocal {

	Optional<Rating> readRating(InterestSpaceUserPK key);

	void createRating(Rating key);

	void updateRating(Rating key);

	void deleteRating(Rating key);

}
