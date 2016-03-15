package gs.ejb.beans;

import java.util.Optional;

import javax.ejb.Remote;

import gs.ejb.domain.InterestContent;

@Remote
public interface InterestContentRemote {

	Optional<InterestContent> getInterestContent(int intConID);

	void createInterestContent(InterestContent intConID);

	void updateInterestContent(InterestContent intConID);

	void deleteInterestContent(InterestContent intConID);

}
