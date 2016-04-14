package domain;

import java.sql.Timestamp;
import java.util.List;

public class Picture {
	
	private long pictureId;
	
	private String imgUrl;
	
	private String description;
	
	private long userId;
	
	private List<UserAlbum> userAlbums;
	
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

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public List<UserAlbum> getUserAlbums() {
		return userAlbums;
	}

	public void setUserAlbums(List<UserAlbum> userAlbums) {
		this.userAlbums = userAlbums;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
}
