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
import domain.User;

/**
 * Entity implementation class for Entity: UserAlbums
 *
 */
@Entity
@NamedQuery(name = "searchPictures",
	query = "SELECT p FROM Pictures p "
			+ "WHERE UPPER(p.user.firstname) LIKE :search "
			+ "OR UPPER(p.user.lastname) LIKE :search "
			+ "ORDER BY p.user.lastname, p.user.firstname")

public class Pictures implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long pictureId;
	
	@NotNull
	private String imgUrl;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="userid")
	private Users user;
	
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
		this.user = new Users().update(picture.getUser());
		this.createdDate = picture.getCreatedDate();
		return this;
	}

	public Picture map(Picture picture) {
		picture.setPictureId(this.getPictureId());
		picture.setImgUrl(this.getImgUrl());
		picture.setUser(this.user.map(new User()));
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

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

}
