package domain;

import java.time.LocalDateTime;

public class UserPictureComment {

	private long id;
	private long userId;
	private String message;
	private LocalDateTime createdDate;
	private long pictureId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
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

	public long getPictureId() {
		return pictureId;
	}

	public void setPictureId(long pictureId) {
		this.pictureId = pictureId;
	}

	@Override
	public String toString() {
		return "UserPictureComment [id=" + id + ", userId=" + userId + ", message=" + message + ", createdDate="
				+ createdDate + ", pictureId=" + pictureId + "]";
	}

}
