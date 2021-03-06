package domain;

import java.sql.Timestamp;

public class Picture {
	
	private long pictureId;
	
	private String imgUrl;
	
	private String description;
	
	private UserProfile userProfile;
	
	private Timestamp createdDate;

	public long getPictureId() {
		return pictureId;
	}

	public void setPictureId(long id) {
		this.pictureId = id;
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

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
}
