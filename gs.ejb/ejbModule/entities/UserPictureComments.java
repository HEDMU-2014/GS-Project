package entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import domain.Picture;
import domain.UserPictureComment;
import domain.UserProfile;

@Entity
@NamedQuery(name = "searchUserPictureComments",
query = "SELECT upc FROM UserPictureComments upc WHERE upc.userProfile.lastname = :search")
public class UserPictureComments implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotNull
	@ManyToOne
	@JoinColumn(name="userProfileId")
	private UserProfiles userProfile;
	private String message;
	private Timestamp createdDate;
	@NotNull
	@ManyToOne
	@JoinColumn(name="pictureId")
	private Pictures picture;
	
	public UserPictureComments() {
	}
	
	public UserPictureComments(UserPictureComment upc) {
		update(upc);
	}
	
	public UserPictureComments update(UserPictureComment upc) {
		this.id = upc.getId();
		this.userProfile = new UserProfiles(upc.getUserProfile());
		this.message = upc.getMessage();
		this.createdDate = Timestamp.valueOf(upc.getCreatedDate());
		this.picture = new Pictures(upc.getPicture());
		return this;
	}
	
	public UserPictureComment map(UserPictureComment upc) {
		upc.setId(id);
		upc.setUserProfile(userProfile.map(new UserProfile()));
		upc.setMessage(message);
		upc.setCreatedDate(createdDate.toLocalDateTime());
		upc.setPicture(picture.map(new Picture()));
		return upc;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public UserProfiles getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfiles userProfile) {
		this.userProfile = userProfile;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Pictures getPicture() {
		return picture;
	}

	public void setPicture(Pictures picture) {
		this.picture = picture;
	}

	@Override
	public String toString() {
		return "UserPictureComments [id=" + id + ", userProfile=" + userProfile + ", message=" + message + ", createdDate="
				+ createdDate + ", picture=" + picture + "]";
	}

}
