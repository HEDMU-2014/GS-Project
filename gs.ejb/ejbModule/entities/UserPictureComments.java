package entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

import domain.Picture;
import domain.UserPictureComment;
import domain.UserProfile;

@Entity
@NamedQuery(name = "searchUserPictureComments",
query = "SELECT upc FROM UserPictureComments upc WHERE upc.user.userid = :search")
public class UserPictureComments implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotNull
	@ManyToOne
	@JoinColumn(name="userProfileId")
	private UserProfiles user;
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
		this.user = new UserProfiles(upc.getUser());
		this.message = upc.getMessage();
		this.createdDate = Timestamp.valueOf(upc.getCreatedDate());
		this.picture = new Pictures(upc.getPicture());
		return this;
	}
	
	public UserPictureComment map(UserPictureComment upc) {
		upc.setId(id);
		upc.setUser(user.map(new UserProfile()));
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

	public UserProfiles getUser() {
		return user;
	}

	public void setUser(UserProfiles user) {
		this.user = user;
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

}
