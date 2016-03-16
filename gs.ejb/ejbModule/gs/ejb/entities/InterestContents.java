package gs.ejb.entities;

import java.io.Serializable;
import javax.persistence.*;

import gs.ejb.domain.InterestContent;

/**
 * Entity implementation class for Entity: test
 *
 */
@Entity

@IdClass(InterestContentsPK.class)
public class InterestContents implements Serializable {

	   
	@Id
	private long userID;   
	@Id
	private int placeID;   
	@Id
	private int interestID;
	private static final long serialVersionUID = 1L;

	public InterestContents() {
		super();
	}   
	public InterestContents(InterestContent intCon) {
		update(intCon);
	}   
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
   

	public InterestContents update(InterestContent intCon) {
		this.interestID = intCon.getInterestID();
		this.placeID = intCon.getPlaceID();
		this.userID = intCon.getUserID();
		return this;
	}
	public InterestContent map(InterestContent intCon) {
		intCon.setInterestID(interestID);
		intCon.setPlaceID(placeID);
		intCon.setUserID(userID);
		return intCon;
	}
}
