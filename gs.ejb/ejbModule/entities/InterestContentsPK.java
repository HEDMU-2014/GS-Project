package entities;

import java.io.Serializable;

/**
 * ID class for entity: test
 *
 */ 
public class InterestContentsPK  implements Serializable {   
   
	         
	private long user;         
	private int place;         
	private int interest;
	private static final long serialVersionUID = 1L;

	public InterestContentsPK() {}

	

	public long getUser() {
		return this.user;
	}

	public void setUser(long userID) {
		this.user = userID;
	}
	

	public int getPlace() {
		return this.place;
	}

	public void setPlace(int placeID) {
		this.place = placeID;
	}
	

	public int getInterest() {
		return this.interest;
	}

	public void setInterestID(int interestID) {
		this.interest = interestID;
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
			&& getUser() == other.getUser()
			&& getPlace() == other.getPlace()
			&& getInterest() == other.getInterest();
	}
	
	/*	 
	 * @see java.lang.Object#hashCode()
	 */	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((int) (getUser() ^ (getUser() >>> 32)));
		result = prime * result + getPlace();
		result = prime * result + getInterest();
		return result;
	}
   
   
}
