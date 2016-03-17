package gs.ejb.beans;

import gs.ejb.domain.Picture;
import gs.ejb.domain.Role;

import java.util.List;

public interface PictureManagerCommon {
   Picture findPicture(long id);

   void createPicture(Picture picture);

   void updatePicture(Picture picture);

   void deletePicture(Picture picture);
}
