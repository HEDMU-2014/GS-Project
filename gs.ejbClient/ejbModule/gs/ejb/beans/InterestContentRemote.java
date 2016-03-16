package gs.ejb.beans;

import java.util.Optional;

import javax.ejb.Remote;

import gs.ejb.domain.InterestContent;

@Remote
public interface InterestContentRemote {

	Optional<InterestContent> getInterestContent(InterestContent intCon);

	void createInterestContent(InterestContent intCon);

	void updateInterestContent(InterestContent intCon);

	void deleteInterestContent(InterestContent intCon);

}
