package entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

import domain.UserPictureComment;

@Entity
@NamedQuery(name = "searchUserPictureComments",
query = "SELECT upc FROM UserPictureComments upc WHERE upc.userId = :search")
public class UserPictureComments implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long userId;
	private String message;
	private Timestamp createdDate;
	private long pictureId;
	
	public UserPictureComments() {
	}
	
	public UserPictureComments(UserPictureComment upc) {
		update(upc);
	}
	
	public UserPictureComments update(UserPictureComment upc) {
		this.id = upc.getId();
		this.userId = upc.getUserId();
		this.message = upc.getMessage();
		this.createdDate = Timestamp.valueOf(upc.getCreatedDate());
		this.pictureId = upc.getPictureId();
		return this;
	}
	
	public UserPictureComment map(UserPictureComment upc) {
		upc.setId(id);
		upc.setUserId(userId);
		upc.setMessage(message);
		upc.setCreatedDate(createdDate.toLocalDateTime());
		upc.setPictureId(pictureId);
		return upc;
	}

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

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
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
		return "UserPictureComments [id=" + id + ", userId=" + userId + ", message=" + message + ", createdDate="
				+ createdDate + ", pictureId=" + pictureId + "]";
	}

}
