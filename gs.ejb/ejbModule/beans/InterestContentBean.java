package beans;

import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.InterestContent;
import domain.InterestSpaceUserPK;
import entities.InterestContents;

/**
 * Session Bean implementation class InterestContentBean
 */
@Stateless
public class InterestContentBean implements InterestContentRemote, InterestContentLocal {
	@PersistenceContext private EntityManager em;

	@Override
	public Optional<InterestContent> readInterestContent(InterestSpaceUserPK key) {
		Optional<InterestContent> opt = Optional.empty();
		InterestContents intCon = em.find(InterestContents.class, key); 
		if (intCon != null) {
			opt = Optional.of(intCon.map(new InterestContent()));
		}
		return opt;
	}
	
	@Override
	public void createInterestContent(InterestContent domain) {
		InterestContents entity = new InterestContents(domain);
		em.persist(entity);
	}
	
	@Override
	public void updateInterestContent(InterestContent domain) {
		InterestSpaceUserPK key = new InterestSpaceUserPK(domain.getUser().getUserid(), domain.getPlace().getPlaceId(), domain.getInterest().getInterestId());
		InterestContents entity = em.find(InterestContents.class, key); 
		if (entity != null) {
			entity.update(domain);
		} else {
			throw new RuntimeException("InterestContent with id " + key + " not found");
		}
	}
	
	@Override
	public void deleteInterestContent(InterestContent domain) {
		InterestSpaceUserPK key = new InterestSpaceUserPK(domain.getUser().getUserid(), domain.getPlace().getPlaceId(), domain.getInterest().getInterestId());
		InterestContents entity = em.find(InterestContents.class, key); 
		if (entity != null) {
			em.remove(entity);
		} else {
			throw new RuntimeException("InterestContent with id " + key + " not found");
		}
	}



}
