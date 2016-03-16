package gs.ejb.entities;

import java.io.Serializable;

/**
 * ID class for entity: test
 *
 */ 
public class InterestContentsPK  implements Serializable {   
   
	         
	private long userID;         
	private int placeID;         
	private int interestID;
	private static final long serialVersionUID = 1L;

	public InterestContentsPK() {}

	

	public long getUserID() {
		return this.userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}
	

	public int getPlaceID() {
		return this.placeID;
	}

	public void setPlaceID(int placeID) {
		this.placeID = placeID;
	}
	

	public int getInterestID() {
		return this.interestID;
	}

	public void setInterestID(int interestID) {
		this.interestID = interestID;
	}
	
   
	/*
	 * @see java.lang.Object#equals(Object)
	 */	
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof InterestContentsPK)) {
			return false;
		}
		InterestContentsPK other = (InterestContentsPK) o;
		return true
			&& getUserID() == other.getUserID()
			&& getPlaceID() == other.getPlaceID()
			&& getInterestID() == other.getInterestID();
	}
	
	/*	 
	 * @see java.lang.Object#hashCode()
	 */	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((int) (getUserID() ^ (getUserID() >>> 32)));
		result = prime * result + getPlaceID();
		result = prime * result + getInterestID();
		return result;
	}
   
   
}
