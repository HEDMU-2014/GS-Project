package beans;

import java.util.List;
import java.util.Optional;

import javax.ejb.Local;

import domain.Rating;

@Local
public interface RatingsBeanLocal {

	public Optional<Rating> readRating(InterestSpaceUserPK key);

	public void createRating(Rating key);

	public void updateRating(Rating key);

	public void deleteRating(Rating key);
	
	public List<Rating> listRatingsForUser(long userid);

}
