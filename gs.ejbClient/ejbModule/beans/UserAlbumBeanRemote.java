package beans;

import java.util.List;
import java.util.Optional;

import javax.ejb.Remote;

import domain.UserAlbum;

@Remote
public interface UserAlbumBeanRemote {

	Optional<UserAlbum> getUserAlbum(long albumId);

	void createUserAlbum(UserAlbum ua);

	void updateUserAlbum(UserAlbum album);

	void deleteUserAlbum(UserAlbum album);
	
	List<UserAlbum> getUserAlbums(long userProfileId);

}
