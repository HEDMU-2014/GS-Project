package gs.ejb.domain;

import java.io.Serializable;

public class InterestContent implements Serializable {
	private static final long serialVersionUID = 1L;

	private int contentID;
	private long userID;
	private int placeID;
	private int interestID;
	   
	
	
	public int getContentID() {
		return contentID;
	}


	public void setContentID(int contentID) {
		this.contentID = contentID;
	}


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
		return "InterestContent [contentID=" + contentID + ", userID=" + userID + ", placeID=" + placeID
				+ ", interestID=" + interestID + "]";
	}

	
   
}
