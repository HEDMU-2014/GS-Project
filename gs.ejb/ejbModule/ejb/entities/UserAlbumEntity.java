package ejb.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import ejb.domain.Picture;
import ejb.domain.User;
import ejb.domain.UserAlbum;

/**
 * Entity implementation class for Entity: UserAlbums
 *
 */
@Entity

public class UserAlbumEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long albumId;
	
	@NotNull
	private UserEntity user;
	
	private PictureEntity coverPicture;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="AlbumPictures",
			joinColumns=@JoinColumn(name="albumId", referencedColumnName="albumId"),
			inverseJoinColumns=@JoinColumn(name="pictureId", referencedColumnName="id"))
	private Collection<PictureEntity> pictures;

	@NotNull
	private Timestamp createdDate;
	
	@NotNull
	private Boolean publicOA;
	
	public UserAlbumEntity() {
		super();
	}
	
	public UserAlbumEntity(UserAlbum ua) {
		update(ua);
	}

	public UserAlbumEntity update(UserAlbum ua) {
		this.albumId = ua.getAlbumId();
		this.user = new UserEntity().update(ua.getUser());
		this.coverPicture = new PictureEntity().update(ua.getCoverPicture());
		this.pictures = new ArrayList<>();
		for(Picture picture : ua.getPictures()) {
			this.pictures.add(new PictureEntity(picture));
		}
		this.createdDate = ua.getCreatedDate();
		this.publicOA = ua.getPublicOA();
		return this;
	}
	
	public UserAlbum map(UserAlbum ua) {
		ua.setAlbumId(this.getAlbumId());
		ua.setUser(user.map(new User()));
		ua.setCoverPicture(coverPicture.map(new Picture()));
		ua.setPictures(new ArrayList<>());
		for (PictureEntity picture : pictures) {
			ua.getPictures().add(picture.map(new Picture()));
		}
		ua.setCreatedDate(this.getCreatedDate());
		ua.setPublicOA(this.getPublicOA());
		return ua;
	}

	public long getAlbumId() {
		return albumId;
	}

	public void setAlbumId(long albumId) {
		this.albumId = albumId;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public PictureEntity getCoverPicture() {
		return coverPicture;
	}

	public void setCoverPicture(PictureEntity coverPicture) {
		this.coverPicture = coverPicture;
	}

	public Collection<PictureEntity> getPictures() {
		return pictures;
	}

	public void setPictures(Collection<PictureEntity> pictures) {
		this.pictures = pictures;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Boolean getPublicOA() {
		return publicOA;
	}

	public void setPublicOA(Boolean publicOA) {
		this.publicOA = publicOA;
	}
   
}
