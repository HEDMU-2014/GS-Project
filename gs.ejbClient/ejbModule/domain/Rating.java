package domain;

import java.io.Serializable;

public class Rating implements Serializable {
	private static final long serialVersionUID = 1L;

	private long userID;
	private int placeID;
	private int interestID;
	private int rating;


	public long getUserID() {
		return userID;
	}


	public void setUserID(long userID) {
		this.userID = userID;
	}


	public int getPlaceID() {
		return placeID;
	}


	public void setPlaceID(int placeID) {
		this.placeID = placeID;
	}


	public int getInterestID() {
		return interestID;
	}


	public void setInterestID(int interestID) {
		this.interestID = interestID;
	}


	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}


	@Override
	public String toString() {
		return "Rating [userID=" + userID + ", placeID=" + placeID + ", interestID=" + interestID + ", rating=" + rating
				+ "]";
	}



	
   
}
