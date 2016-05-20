package domain;

import java.io.Serializable;

public class InterestContent implements Serializable {
	private static final long serialVersionUID = 1L;

	private UserProfile user;
	private Place place;
	private Interest interest;


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


	@Override
	public String toString() {
		return "InterestContent [user=" + user + ", place=" + place + ", interest=" + interest + "]";
	}



	
   
}
