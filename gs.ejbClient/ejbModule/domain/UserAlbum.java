package domain;

import java.sql.Timestamp;
import java.util.Collection;


public class UserAlbum {
	
	private long albumId;
	
	private UserProfile userProfile;
	
	private String name;
	
	private Picture coverPicture;
	
	private Collection<Picture> pictures;

	private Timestamp createdDate;
	
	private Boolean publicOA;

	public long getAlbumId() {
		return albumId;
	}

	public void setAlbumId(long albumId) {
		this.albumId = albumId;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Picture getCoverPicture() {
		return coverPicture;
	}

	public void setCoverPicture(Picture coverPicture) {
		this.coverPicture = coverPicture;
	}

	public Collection<Picture> getPictures() {
		return pictures;
	}

	public void setPictures(Collection<Picture> pictures) {
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
