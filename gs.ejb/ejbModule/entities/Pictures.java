package entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

import domain.Picture;
import domain.UserProfile;

/**
 * Entity implementation class for Entity: UserAlbums
 *
 */
@Entity
@NamedQuery(name = "getPictures",
query = "SELECT p FROM Pictures p "
		+ "WHERE p.userProfile.lastname LIKE :search ")

public class Pictures implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long pictureId;
	
	@NotNull
	private String imgUrl;
	
	@Column(length=200)
	private String description;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="userProfileId")
	private UserProfiles userProfile;
	
	@NotNull
	private Timestamp createdDate;
	
	public Pictures() {
		super();
	}
	
	public Pictures(Picture picture) {
		update(picture);
	}

	public Pictures update(Picture picture) {
		this.pictureId = picture.getPictureId();
		this.imgUrl = picture.getImgUrl();
		this.description = picture.getDescription();
		this.userProfile = new UserProfiles(picture.getUserProfile());
		this.createdDate = picture.getCreatedDate();
		return this;
	}

	public Picture map(Picture picture) {
		picture.setPictureId(this.getPictureId());
		picture.setImgUrl(this.getImgUrl());
		picture.setDescription(this.getDescription());
		picture.setUserProfile(this.userProfile.getDomUserProfile(new UserProfile()));
		picture.setCreatedDate(this.getCreatedDate());
		return picture;
	}

	public long getPictureId() {
		return pictureId;
	}

	public void setPictureId(long pictureId) {
		this.pictureId = pictureId;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UserProfiles getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfiles user) {
		this.userProfile = user;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

}
