package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;

import beans.InterestSpaceUserPK;
import domain.Interest;
import domain.Place;
import domain.Rating;
import domain.UserProfile;

/**
 * Entity implementation class for Entity: Ratings
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "listRatingsForUser", 
	query = "SELECT r FROM Ratings r  "
		+ "WHERE r.user.userid = :userid ")
	})

@IdClass(InterestSpaceUserPK.class)
public class Ratings implements Serializable {

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
	
	private int rating;
	
	private static final long serialVersionUID = 1L;

	public Ratings() {
		super();
	}   
	public Ratings(Rating rating) {
		update(rating);
	}   
   

	public Ratings update(Rating domain) {
		this.interest = new Interests(domain.getInterest());
		this.place = new Places(domain.getPlace());
		this.user = new UserProfiles(domain.getUser());
		this.rating = domain.getRating();
		return this;
	}
	public Rating map(Rating rating) {
		rating.setInterest(interest.map(new Interest()));
		rating.setPlace(place.map(new Place()));
		rating.setUser(user.map(new UserProfile()));
		rating.setRating(this.rating);
		return rating;
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
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
}
