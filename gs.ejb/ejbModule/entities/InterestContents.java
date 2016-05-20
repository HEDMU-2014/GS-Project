package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import domain.Interest;
import domain.InterestContent;
import domain.InterestSpaceUserPK;
import domain.Place;
import domain.UserProfile;

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
		this.interest = new Interests(intCon.getInterest());
		this.place = new Places(intCon.getPlace());
		this.user = new UserProfiles(intCon.getUser());
		return this;
	}
	public InterestContent map(InterestContent intCon) {
		intCon.setInterest(interest.map(new Interest()));
		intCon.setPlace(place.map(new Place()));
		intCon.setUser(user.map(new UserProfile()));
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
