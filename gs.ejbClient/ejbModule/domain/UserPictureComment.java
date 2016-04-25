package domain;

import java.time.LocalDateTime;

public class UserPictureComment {

	private long id;
	private UserProfile userProfile;
	private String message;
	private LocalDateTime createdDate;
	private Picture picture;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public Picture getPicture() {
		return picture;
	}

	public void setPicture(Picture picture) {
		this.picture = picture;
	}

	@Override
	public String toString() {
		return "UserPictureComment [id=" + id + ", userProfile=" + userProfile + ", message=" + message + ", createdDate="
				+ createdDate + ", picture=" + picture + "]";
	}

}
