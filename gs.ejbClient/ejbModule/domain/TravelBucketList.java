package domain;

import java.io.Serializable;

public class TravelBucketList implements Serializable {
	private static final long serialVersionUID = 1L;

	private long userID;
	private int placeID;
	private int interestID;


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


	@Override
	public String toString() {
		return "TravelBucketList [userID=" + userID + ", placeID=" + placeID + ", interestID=" + interestID + "]";
	}

   
}
