package beans;

import java.util.Optional;

import javax.ejb.Local;

import domain.InterestContent;

@Local
public interface InterestContentLocal {

	Optional<InterestContent> readInterestContent(InterestSpaceUserPK key);

	void createInterestContent(InterestContent key);

	void updateInterestContent(InterestContent key);

	void deleteInterestContent(InterestContent key);

}
