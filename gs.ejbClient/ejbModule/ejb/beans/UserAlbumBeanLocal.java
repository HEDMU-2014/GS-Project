package ejb.beans;

import java.util.List;
import java.util.Optional;

import javax.ejb.Local;

import ejb.domain.UserAlbum;

@Local
public interface UserAlbumBeanLocal {

	Optional<UserAlbum> getUserAlbum(long albumId);

	void createUserAlbum(UserAlbum ua);

	void updateUserAlbum(UserAlbum album);

	void deleteUserAlbum(UserAlbum album);

	List<UserAlbum> searchUserAlbums(String search);

}
