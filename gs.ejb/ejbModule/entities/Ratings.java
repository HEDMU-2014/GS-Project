package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import domain.Rating;

@Entity
public class Ratings implements Serializable {
	@Id
	private int userId;
	private int interestId;
	private int placeId;
	private int rating;
	private static final long serialVersionUID = 1L;
	
	public Ratings() {
		super();
	}
	
	public Ratings(Rating rating) {
		update(rating);
	}
	
	public Ratings update(Rating rating) {
		this.userId = rating.getUserId();
		this.interestId = rating.getInterestId();
		this.placeId = rating.getPlaceId();
		this.rating = rating.getRating();
		return this;
	}
	
	public Rating map(Rating rating) {
		rating.setUserId(this.userId);
		rating.setInterestId(this.interestId);
		rating.setPlaceId(this.placeId);
		rating.setRating(this.rating);
		return rating;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getInterestId() {
		return interestId;
	}
	
	public void setInterestId(int interestId) {
		this.interestId = interestId;
	}
	
	public int getPlaceId() {
		return placeId;
	}
	
	public void setPlaceId(int placeId) {
		this.placeId = placeId;
	}
	
	public int getRating() {
		return rating;
	}
	
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		return "Rating [userId=" + userId + ", interestId=" + interestId 
				+ ", placeId=" + placeId + ", rating=" + rating + "]";
	}

}
