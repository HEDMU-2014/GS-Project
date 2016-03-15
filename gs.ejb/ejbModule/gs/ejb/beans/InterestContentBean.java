package gs.ejb.beans;

import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import gs.ejb.domain.InterestContent;
import gs.ejb.entities.InterestContents;

/**
 * Session Bean implementation class InterestContentBean
 */
@Stateless
public class InterestContentBean implements InterestContentRemote, InterestContentLocal {
	@PersistenceContext private EntityManager em;

	@Override
	public Optional<InterestContent> getInterestContent(int intConID) {
		Optional<InterestContent> opt = Optional.empty();
		InterestContents intCon = em.find(InterestContents.class, intConID); 
		if (intCon != null) {
			opt = Optional.of(intCon.map(new InterestContent()));
		}
		return opt;
	}
	
	@Override
	public void createInterestContent(InterestContent intConID) {
		InterestContents entity = new InterestContents(intConID);
		em.persist(entity);
	}
	
	@Override
	public void updateInterestContent(InterestContent intConID) {
		InterestContents entity = em.find(InterestContents.class, intConID.getContentID()); 
		if (entity != null) {
			entity.update(intConID);
		} else {
			throw new RuntimeException("InterestContent with id " + intConID.getContentID() + " not found");
		}
	}
	
	@Override
	public void deleteInterestContent(InterestContent intConID) {
		InterestContent entity = em.find(InterestContent.class, intConID.getContentID()); 
		if (entity != null) {
			em.remove(entity);
		} else {
			throw new RuntimeException("InterestContent with id " + intConID.getContentID() + " not found");
		}
	}



}
