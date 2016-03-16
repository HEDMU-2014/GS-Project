package gs.ejb.beans;

import java.util.Optional;

import javax.ejb.Local;

import gs.ejb.domain.InterestContent;

@Local
public interface InterestContentLocal {

	Optional<InterestContent> getInterestContent(InterestContent intCon);

	void createInterestContent(InterestContent intCon);

	void updateInterestContent(InterestContent intCon);

	void deleteInterestContent(InterestContent intCon);

}
