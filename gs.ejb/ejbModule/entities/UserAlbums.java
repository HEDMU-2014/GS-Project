package entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

import domain.Picture;
import domain.UserAlbum;

/**
 * Entity implementation class for Entity: UserAlbums
 *
 */
@Entity
@NamedQuery(name = "getUserAlbums",
	query = "SELECT ua FROM UserAlbums ua "
			+ "WHERE ua.userProfile.lastname LIKE :search ")

public class UserAlbums implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long albumId;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="userProfileId")
	private UserProfiles userProfile;
	
	@Column(nullable=false, length=50)
	private String name;
	
	@ManyToOne
	@JoinColumn(name="coverPictureId")
	private Pictures coverPicture;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="AlbumPictures",
			joinColumns=@JoinColumn(name="albumId", referencedColumnName="albumId"),
			inverseJoinColumns=@JoinColumn(name="pictureId", referencedColumnName="pictureId"))
	private Collection<Pictures> pictures;

	@NotNull
	private Timestamp createdDate;
	
	@NotNull
	private Boolean publicOA;
	
	public UserAlbums() {
		super();
	}
	
	public UserAlbums(UserAlbum ua) {
		update(ua);
	}

	public UserAlbums update(UserAlbum ua) {
		this.albumId = ua.getAlbumId();
		this.userProfile = new UserProfiles();
		this.userProfile.setUserid(ua.getUserId());
		this.name = ua.getName();
		this.coverPicture = new Pictures(ua.getCoverPicture());
		this.pictures = new ArrayList<>();
		for(Picture picture : ua.getPictures()) {
			this.pictures.add(new Pictures(picture));
		}
		this.createdDate = ua.getCreatedDate();
		this.publicOA = ua.getPublicOA();
		return this;
	}
	
	public UserAlbum map(UserAlbum ua) {
		ua.setAlbumId(this.getAlbumId());
		ua.setUserId(this.userProfile.getUserid());
		ua.setName(this.getName());
		ua.setCoverPicture(coverPicture.map(new Picture()));
		ua.setPictures(new ArrayList<>());
		for (Pictures picture : this.getPictures()) {
			ua.getPictures().add(picture.map(new Picture()));
		}
		ua.setPictures(new ArrayList<>());
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

	public UserProfiles getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfiles userProfile) {
		this.userProfile = userProfile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Pictures getCoverPicture() {
		return coverPicture;
	}

	public void setCoverPicture(Pictures coverPicture) {
		this.coverPicture = coverPicture;
	}

	public Collection<Pictures> getPictures() {
		return pictures;
	}

	public void setPictures(Collection<Pictures> pictures) {
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
