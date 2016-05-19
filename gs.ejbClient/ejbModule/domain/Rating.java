package domain;

import java.io.Serializable;

public class Rating implements Serializable {
	private static final long serialVersionUID = 1L;

	private UserProfile user;
	private Place place;
	private Interest interest;
	private int rating;


	public UserProfile getUser() {
		return user;
	}


	public void setUser(UserProfile user) {
		this.user = user;
	}


	public Place getPlace() {
		return place;
	}


	public void setPlace(Place place) {
		this.place = place;
	}


	public Interest getInterest() {
		return interest;
	}


	public void setInterest(Interest interest) {
		this.interest = interest;
	}


	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}


	@Override
	public String toString() {
		return "Rating [user=" + user + ", place=" + place + ", interest=" + interest + ", rating=" + rating
				+ "]";
	}



	
   
}
