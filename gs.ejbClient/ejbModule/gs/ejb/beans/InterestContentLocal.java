package gs.ejb.beans;

import java.util.Optional;

import javax.ejb.Local;

import gs.ejb.domain.InterestContent;

@Local
public interface InterestContentLocal {

	Optional<InterestContent> getInterestContent(InterestContent key);

	void createInterestContent(InterestContent key);

	void updateInterestContent(InterestContent key);

	void deleteInterestContent(InterestContent key);

}
