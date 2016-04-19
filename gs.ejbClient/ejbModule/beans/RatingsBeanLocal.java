package beans;

import java.util.Optional;

import javax.ejb.Local;

import domain.Rating;

@Local
public interface RatingsBeanLocal {
	public void create(Rating rating);
	public Optional<Rating> read(int rating);
	public void update(Rating rating);
	public void delete(Rating rating);

}
