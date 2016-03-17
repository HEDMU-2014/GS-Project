package ejb.beans;

import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ejb.domain.UserAlbum;
import ejb.entities.UserAlbumEntity;

/**
 * Session Bean implementation class UserAlbumBean
 */
@Stateless
public class UserAlbumBean implements UserAlbumBeanRemote, UserAlbumBeanLocal {
	@PersistenceContext private EntityManager em;
    
	@Override
    public Optional<UserAlbum> getUserAlbum(long albumId) {
    	Optional<UserAlbum> optional = Optional.empty();
    	UserAlbumEntity albumEntity = em.find(UserAlbumEntity.class, albumId);
    	if (albumEntity != null)
    		optional = Optional.of(albumEntity.map(new UserAlbum()));
    	return optional;
    }
	
	@Override
	public void createUserAlbum(UserAlbum album) {
		UserAlbumEntity albumEntity = new UserAlbumEntity(album);
		em.persist(albumEntity);
	}
	
	@Override
	public void updateUserAlbum(UserAlbum album) {
		UserAlbumEntity albumEntity = em.find(UserAlbumEntity.class, album.getAlbumId());
		if (albumEntity != null)
			albumEntity.update(album);
		else
			throw new RuntimeException("Album with id " + album.getAlbumId() + " not found");
	}
	
	@Override
	public void deleteUserAlbum(UserAlbum album) {
		UserAlbumEntity albumEntity = em.find(UserAlbumEntity.class, album.getAlbumId());
		if (albumEntity != null)
			em.remove(albumEntity);
		else
			throw new RuntimeException("Album with id " + album.getAlbumId() + " not found");
	}

}
