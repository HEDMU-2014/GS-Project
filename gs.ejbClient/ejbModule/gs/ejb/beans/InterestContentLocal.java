package gs.ejb.beans;

import java.util.Optional;

import javax.ejb.Local;

import gs.ejb.domain.InterestContent;

@Local
public interface InterestContentLocal {

	Optional<InterestContent> getInterestContent(int intConID);

	void createInterestContent(InterestContent intConID);

	void updateInterestContent(InterestContent intConID);

	void deleteInterestContent(InterestContent intConID);

}
