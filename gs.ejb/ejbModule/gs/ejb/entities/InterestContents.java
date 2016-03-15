package gs.ejb.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import gs.ejb.domain.InterestContent;

/**
 * Entity implementation class for Entity: Organizations
 *
 */
@Entity

public class InterestContents implements Serializable {
	private static final long serialVersionUID = 1L;

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int contentID;
	
	@Column(length=50, nullable=false)
	private long userID;
	
	@Column(length=50, nullable=false)
	private int placeID;
	
	@Column(length=50, nullable=false)
	private int interestID;

	public InterestContents() {
		super();
	} 
	
	public InterestContents(InterestContent intCon) {
		update(intCon);
	} 
	
	public InterestContents update(InterestContent intCon) {
		this.contentID = intCon.getContentID();
		this.userID = intCon.getUserID();
		this.placeID = intCon.getPlaceID();
		this.interestID = intCon.getInterestID();
		return this;
	}
	public InterestContent map(InterestContent intCon) {
		intCon.setContentID(contentID);
		intCon.setUserID(userID);
		intCon.setPlaceID(placeID);
		intCon.setInterestID(interestID);
		return intCon;
	}

	public int getContentID() {
		return contentID;
	}

	//public void setContentID(int contentID) {
	//	this.contentID = contentID;
	//}

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
}
