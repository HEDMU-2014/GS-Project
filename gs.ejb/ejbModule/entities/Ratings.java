package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import beans.InterestSpaceUserPK;
import domain.Rating;

/**
 * Entity implementation class for Entity: Ratings
 *
 */
@Entity

@IdClass(InterestSpaceUserPK.class)
public class Ratings implements Serializable {

	@ManyToOne()
	@Id
	@PrimaryKeyJoinColumn(name="userID", referencedColumnName="userid")
	private Users user;
	
	@ManyToOne
	@Id
	@PrimaryKeyJoinColumn(name="placeID", referencedColumnName="placeId")
	private Places place;
	
	@ManyToOne
	@Id
	@PrimaryKeyJoinColumn(name="interestID", referencedColumnName="interestId")
	private Interests interest;
	
	private int rating;
	
	private static final long serialVersionUID = 1L;

	public Ratings() {
		super();
	}   
	public Ratings(Rating rating) {
		update(rating);
	}   
   

	public Ratings update(Rating intCon) {
//		this.interestID = intCon.getInterestID();
//		this.placeID = intCon.getPlaceID();
//		this.userID = intCon.getUserID();
		return this;
	}
	public Rating map(Rating rating) {
		rating.setInterestID(interest.getInterestId());
		rating.setPlaceID(place.getPlaceId());
		rating.setUserID(user.getUserid());
		rating.setRating(this.rating);
		return rating;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
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
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
}
