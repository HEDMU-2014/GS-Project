package gs.web;

import domain.UserAlbum;
import domain.UserProfile;

public class UserAlbumWrapper {
	private UserAlbum userAlbum;
	private UserProfile userProfile;
	
	public UserAlbum getUserAlbum() {
		return userAlbum;
	}
	public void setUserAlbum(UserAlbum userAlbum) {
		this.userAlbum = userAlbum;
	}
	public UserProfile getUserProfile() {
		return userProfile;
	}
	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

}
