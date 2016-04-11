package domain;

import java.sql.Timestamp;

public class Picture {
	
	private long pictureId;
	
	private String imgUrl;
	
	private User user;
	
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
}
