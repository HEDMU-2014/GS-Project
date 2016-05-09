package beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.Picture;
import entities.Pictures;

/**
 * Session Bean implementation class PictureBean
 */
@Stateless
public class PictureBean implements PictureBeanRemote, PictureBeanLocal {
	@PersistenceContext private EntityManager em;

	@Override
    public Optional<Picture> getPicture(long pictureId) {
    	Optional<Picture> optional = Optional.empty();
    	Pictures pictureEntity = em.find(Pictures.class, pictureId);
    	if (pictureEntity != null)
    		optional = Optional.of(pictureEntity.map(new Picture()));
    	return optional;
    }
	
	@Override
	public List<Picture> getPictures(long userProfileId) {
		List<Picture> pictures = new ArrayList<>();
		List<Pictures> pictureEntity = em.createNamedQuery("getPictures", Pictures.class)
				.setParameter("search", "%" + userProfileId + "%")
				.getResultList();
		for (Pictures pic : pictureEntity) {
			pictures.add(pic.map(new Picture()));
		}
		return pictures;
	}
	
	@Override
	public void createPicture(Picture picture) {
		Pictures pictureEntity = new Pictures(picture);
		em.persist(pictureEntity);
	}
	
	@Override
	public void updatePicture(Picture picture) {
		Pictures pictureEntity = em.find(Pictures.class, picture.getPictureId());
		if (pictureEntity != null)
			pictureEntity.update(picture);
		else
			throw new RuntimeException("Picture with id " + picture.getPictureId() + " not found");
	}
	
	
	@Override
	public void deletePicture(Picture picture) {
		Pictures pictureEntity = em.find(Pictures.class, picture.getPictureId());
		if (pictureEntity != null)
			em.remove(picture);
		else
			throw new RuntimeException("Picture with id " + picture.getPictureId() + " not found");
	}

}
