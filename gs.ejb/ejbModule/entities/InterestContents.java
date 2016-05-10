package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import beans.InterestSpaceUserPK;
import domain.InterestContent;

/**
 * Entity implementation class for Entity: InterestContents
 *
 */
@Entity

@IdClass(InterestSpaceUserPK.class)
public class InterestContents implements Serializable {

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

	public InterestContents() {
		super();
	}   
	public InterestContents(InterestContent intCon) {
		update(intCon);
	}   
   

	public InterestContents update(InterestContent intCon) {
//		this.interestID = intCon.getInterestID();
//		this.placeID = intCon.getPlaceID();
//		this.userID = intCon.getUserID();
		return this;
	}
	public InterestContent map(InterestContent intCon) {
		intCon.setInterestID(interest.getInterestId());
		intCon.setPlaceID(place.getPlaceId());
		intCon.setUserID(user.getUserid());
		return intCon;
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
