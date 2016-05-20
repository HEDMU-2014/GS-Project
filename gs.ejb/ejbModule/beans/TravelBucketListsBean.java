package beans;

import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.InterestSpaceUserPK;
import domain.TravelBucketList;
import entities.TravelBucketLists;

/**
 * Session Bean implementation class TravlBucketListsBean
 */
@Stateless
public class TravelBucketListsBean implements TravelBucketListBeanLocal {
	@PersistenceContext private EntityManager em;

	@Override
	public Optional<TravelBucketList> readTravelBucketList(InterestSpaceUserPK key) {
		Optional<TravelBucketList> opt = Optional.empty();
		TravelBucketLists intCon = em.find(TravelBucketLists.class, key); 
		if (intCon != null) {
			opt = Optional.of(intCon.map(new TravelBucketList()));
		}
		return opt;
	}
	
	@Override
	public void createTravelBucketList(TravelBucketList key) {
		TravelBucketLists entity = new TravelBucketLists(key);
		em.persist(entity);
	}
	
	@Override
	public void updateTravelBucketList(TravelBucketList domain) {
		InterestSpaceUserPK key = new InterestSpaceUserPK(domain.getUser().getUserid(), domain.getPlace().getPlaceId(), domain.getInterest().getInterestId());
		TravelBucketLists entity = em.find(TravelBucketLists.class, key); 
		if (entity != null) {
			entity.update(domain);
		} else {
			throw new RuntimeException("TravelBucketList with id " + key + " not found");
		}
	}
	
	@Override
	public void deleteTravelBucketList(TravelBucketList domain) {
		InterestSpaceUserPK key = new InterestSpaceUserPK(domain.getUser().getUserid(), domain.getPlace().getPlaceId(), domain.getInterest().getInterestId());
		TravelBucketLists entity = em.find(TravelBucketLists.class, key); 
		if (entity != null) {
			em.remove(entity);
		} else {
			throw new RuntimeException("TravelBucketList with id " + key + " not found");
		}
	}



}
