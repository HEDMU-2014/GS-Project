package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import domain.Relation;
import domain.UserProfile;
import domain.UserRelationPK;

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
	private UserProfiles user;
	
	@ManyToOne
	@Id
	@PrimaryKeyJoinColumn(name="followerID", referencedColumnName="userid")
	private UserProfiles follower;
	
	
	private static final long serialVersionUID = 1L;

	public Relations() {
		super();
	}   
	public Relations(Relation domain) {
		update(domain);
	}   
   

	public Relations update(Relation relation) {
		this.user = new UserProfiles(relation.getUser());
		this.follower = new UserProfiles(relation.getFollower());
		return this;
	}
	
	public Relation map(Relation domain) {
		domain.setUser(user.map(new UserProfile()));
		domain.setFollower(follower.map(new UserProfile()));
		return domain;
	}
	public UserProfiles getUser() {
		return user;
	}
	public void setUser(UserProfiles user) {
		this.user = user;
	}
	public UserProfiles getFollower() {
		return follower;
	}
	public void setFollower(UserProfiles follower) {
		this.follower = follower;
	}
}
