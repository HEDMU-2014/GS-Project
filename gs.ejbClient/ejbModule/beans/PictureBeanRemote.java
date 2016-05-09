package beans;

import java.util.List;
import java.util.Optional;

import javax.ejb.Remote;

import domain.Picture;

@Remote
public interface PictureBeanRemote {
	
	Optional<Picture> getPicture(long pictureId);
	
	void createPicture(Picture picture);
	
	void updatePicture(Picture picture);
	
	void deletePicture(Picture picture);
	
	List<Picture> getPictures(long userProfileId);

}
