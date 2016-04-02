package beans;

import java.util.Optional;

import javax.ejb.Remote;

import domain.InterestContent;

@Remote
public interface InterestContentRemote {

	Optional<InterestContent> getInterestContent(InterestContent key);

	void createInterestContent(InterestContent key);

	void updateInterestContent(InterestContent key);

	void deleteInterestContent(InterestContent key);

}
