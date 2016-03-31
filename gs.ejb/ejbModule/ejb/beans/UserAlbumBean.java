package ejb.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.jws.WebService;
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
	
	@Override
	public List<UserAlbum> searchUserAlbums(String search) {
		List<UserAlbum> userAlbums = new ArrayList<>();
		List<UserAlbumEntity> userAlbumsEntity = em.createNamedQuery("searchUserAlbums", UserAlbumEntity.class)
				.setParameter("search", "%" + search.toUpperCase() + "%")
				.getResultList();
		for (UserAlbumEntity uae : userAlbumsEntity) {
			userAlbums.add(uae.map(new UserAlbum()));
		}
		return userAlbums;
	}

}
