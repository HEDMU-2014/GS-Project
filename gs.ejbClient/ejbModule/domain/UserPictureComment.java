package domain;

import java.time.LocalDateTime;

public class UserPictureComment {

	private long id;
	private UserProfile user;
	private String message;
	private LocalDateTime createdDate;
	private Picture picture;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public UserProfile getUser() {
		return user;
	}

	public void setUser(UserProfile user) {
		this.user = user;
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
		return "UserPictureComment [id=" + id + ", user=" + user + ", message=" + message + ", createdDate="
				+ createdDate + ", picture=" + picture + "]";
	}

}
