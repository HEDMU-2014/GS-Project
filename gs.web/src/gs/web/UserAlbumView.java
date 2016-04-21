package gs.web;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.jboss.logging.Logger;

import beans.UserAlbumBeanLocal;
import beans.UserProfilesBeanLocal;
import domain.UserAlbum;
import domain.UserProfile;

@Named
@SessionScoped
public class UserAlbumView implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB private UserAlbumBeanLocal userAlbumEJB;
	@EJB private UserProfilesBeanLocal userProfileEJB;
	private Logger logger = Logger.getLogger(UserAlbumView.class);
	private long searchstring;
	private List<UserAlbumWrapper> userAlbums;
	private UserAlbumWrapper selectedUserAlbum;
	
	public void searchUserId() {
		logger.info("UserId : " + searchstring);
		List<UserAlbum> userAlbums = userAlbumEJB.getUserAlbums(searchstring);
		this.userAlbums = new ArrayList<UserAlbumWrapper>();

		for (UserAlbum ua : userAlbums) {
			UserAlbumWrapper uaw = new UserAlbumWrapper();
			Optional<UserProfile> userProfile = userProfileEJB.readUserProfile((int) ua.getUserId());
			uaw.setUserProfile(userProfile.get());
			uaw.setUserAlbum(ua);
			this.userAlbums.add(uaw);
		}
	}
	
	public long getSearchstring() {
		return searchstring;
	}
	
	public void setSearchstring(long searchstring) {
		this.searchstring = searchstring;
	}

	public List<UserAlbumWrapper> getUserAlbums() {
		return userAlbums;
	}

	public void setUserAlbums(List<UserAlbumWrapper> userAlbums) {
		this.userAlbums = userAlbums;
	}

	public UserAlbumWrapper getSelectedUserAlbum() {
		return selectedUserAlbum;
	}

	public void setSelectedUserAlbum(UserAlbumWrapper selectedUserAlbum) {
		this.selectedUserAlbum = selectedUserAlbum;
	}
	
}
