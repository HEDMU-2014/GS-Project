package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import beans.UserRelationPK;
import domain.Relation;

/**
 * Entity implementation class for Entity: Ratings
 *
 */
@Entity

@IdClass(UserRelationPK.class)
public class Relations implements Serializable {

	@ManyToOne()
	@Id
	@PrimaryKeyJoinColumn(name="userID", referencedColumnName="userid")
	private Users user;
	
	@ManyToOne
	@Id
	@PrimaryKeyJoinColumn(name="relationID", referencedColumnName="userid")
	private Users relation;
	
	private boolean userFollowRelation;
	
	private static final long serialVersionUID = 1L;

	public Relations() {
		super();
	}   
	public Relations(Relation domain) {
		update(domain);
	}   
   

	public Relations update(Relation intCon) {
//		this.interestID = intCon.getInterestID();
//		this.placeID = intCon.getPlaceID();
//		this.userID = intCon.getUserID();
		return this;
	}
	public Relation map(Relation domain) {
		domain.setUserID(user.getUserid());
		domain.setRelationid(relation.getUserid());
		domain.setUserFollowRelation(userFollowRelation);
		return domain;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Users getRelation() {
		return relation;
	}
	public void setRelation(Users relation) {
		this.relation = relation;
	}
	public boolean isUserFollowRelation() {
		return userFollowRelation;
	}
	public void setUserFollowRelation(boolean userFollowRelation) {
		this.userFollowRelation = userFollowRelation;
	}
}
