package beans;

import java.util.Optional;

import javax.ejb.Local;

import domain.TravelBucketList;

@Local
public interface TravelBucketListBeanLocal {

	Optional<TravelBucketList> readTravelBucketList(InterestSpaceUserPK key);

	void createTravelBucketList(TravelBucketList key);

	void updateTravelBucketList(TravelBucketList key);

	void deleteTravelBucketList(TravelBucketList key);

}
