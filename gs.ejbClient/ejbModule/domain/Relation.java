package domain;

import java.io.Serializable;

public class Relation implements Serializable {
	private static final long serialVersionUID = 1L;

	private long userID;
	private long relationid;
	private boolean userFollowRelation;


	public long getUserID() {
		return userID;
	}


	public void setUserID(long userID) {
		this.userID = userID;
	}


	public long getRelationid() {
		return relationid;
	}


	public void setRelationid(long relationid) {
		this.relationid = relationid;
	}


	public boolean isUserFollowRelation() {
		return userFollowRelation;
	}


	public void setUserFollowRelation(boolean userFollowRelation) {
		this.userFollowRelation = userFollowRelation;
	}


	@Override
	public String toString() {
		return "Relation [userID=" + userID + ", relationid=" + relationid + ", userFollowRelation="
				+ userFollowRelation + "]";
	}

}
