package beans;

import java.util.List;
import java.util.Optional;

import javax.ejb.Local;

import domain.Picture;

@Local
public interface PictureBeanLocal {

	Optional<Picture> getPicture(long pictureId);

	void createPicture(Picture picture);

	void updatePicture(Picture picture);

	void deletePicture(Picture picture);

	List<Picture> getPictures(long userProfileId);

}
