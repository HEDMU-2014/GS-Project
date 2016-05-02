package beans;

import domain.Picture;

import javax.ejb.ObjectNotFoundException;
import java.util.List;

public interface PictureBeanCommon {
   List<Picture> listAll();

   Picture find(Long id) throws ObjectNotFoundException;

   Picture create(Picture picture);

   void update(Picture picture) throws ObjectNotFoundException;

   void delete(Picture picture) throws ObjectNotFoundException;
}
