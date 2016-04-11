package beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.UserAlbum;
import entities.UserAlbums;

/**
 * Session Bean implementation class UserAlbumBean
 */
@Stateless
public class UserAlbumBean implements UserAlbumBeanRemote, UserAlbumBeanLocal {
	@PersistenceContext private EntityManager em;
    
	@Override
    public Optional<UserAlbum> getUserAlbum(long albumId) {
    	Optional<UserAlbum> optional = Optional.empty();
    	UserAlbums albumEntity = em.find(UserAlbums.class, albumId);
    	if (albumEntity != null)
    		optional = Optional.of(albumEntity.map(new UserAlbum()));
    	return optional;
    }
	
	@Override
	public void createUserAlbum(UserAlbum album) {
		UserAlbums albumEntity = new UserAlbums(album);
		em.persist(albumEntity);
	}
	
	@Override
	public void updateUserAlbum(UserAlbum album) {
		UserAlbums albumEntity = em.find(UserAlbums.class, album.getAlbumId());
		if (albumEntity != null)
			albumEntity.update(album);
		else
			throw new RuntimeException("Album with id " + album.getAlbumId() + " not found");
	}
	
	@Override
	public void deleteUserAlbum(UserAlbum album) {
		UserAlbums albumEntity = em.find(UserAlbums.class, album.getAlbumId());
		if (albumEntity != null)
			em.remove(albumEntity);
		else
			throw new RuntimeException("Album with id " + album.getAlbumId() + " not found");
	}
	
	@Override
	public List<UserAlbum> searchUserAlbums(String search) {
		List<UserAlbum> userAlbums = new ArrayList<>();
		List<UserAlbums> userAlbumsEntity = em.createNamedQuery("searchUserAlbums", UserAlbums.class)
				.setParameter("search", "%" + search.toUpperCase() + "%")
				.getResultList();
		for (UserAlbums uae : userAlbumsEntity) {
			userAlbums.add(uae.map(new UserAlbum()));
		}
		return userAlbums;
	}

}
