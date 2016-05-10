package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import beans.InterestSpaceUserPK;
import domain.TravelBucketList;

/**
 * Entity implementation class for Entity: TravelBucketLists
 *
 */
@Entity

@IdClass(InterestSpaceUserPK.class)
public class TravelBucketLists implements Serializable {

	@ManyToOne()
	@Id
	@PrimaryKeyJoinColumn(name="userID", referencedColumnName="userid")
	private UserProfiles user;
	
	@ManyToOne
	@Id
	@PrimaryKeyJoinColumn(name="placeID", referencedColumnName="placeId")
	private Places place;
	
	@ManyToOne
	@Id
	@PrimaryKeyJoinColumn(name="interestID", referencedColumnName="interestId")
	private Interests interest;
	
	private static final long serialVersionUID = 1L;

	public TravelBucketLists() {
		super();
	}   
	public TravelBucketLists(TravelBucketList domain) {
		update(domain);
	}   
   

	public TravelBucketLists update(TravelBucketList domain) {
//		this.interestID = intCon.getInterestID();
//		this.placeID = intCon.getPlaceID();
//		this.userID = intCon.getUserID();
		return this;
	}
	public TravelBucketList map(TravelBucketList domain) {
		domain.setInterestID(interest.getInterestId());
		domain.setPlaceID(place.getPlaceId());
		domain.setUserID(user.getUserid());
		return domain;
	}
	public UserProfiles getUser() {
		return user;
	}
	public void setUser(UserProfiles user) {
		this.user = user;
	}
	public Places getPlace() {
		return place;
	}
	public void setPlace(Places place) {
		this.place = place;
	}
	public Interests getInterest() {
		return interest;
	}
	public void setInterest(Interests interest) {
		this.interest = interest;
	}
}
