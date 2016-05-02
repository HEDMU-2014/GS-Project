package beans;

import domain.Picture;
import entities.Pictures;

import javax.ejb.Stateless;
import java.util.Date;
import java.util.List;

@Stateless
public class PictureBean extends ManagerBean<Picture, Pictures, Long>
      implements PictureBeanLocal, PictureBeanRemote {

   public PictureBean() {
      super(Picture.class, Pictures.class);
   }

   @Override
   public List<Picture> listAll() {
      return query(Pictures.listAll);
   }

   @Override
   public Picture create(Picture picture) {
      picture.setCreatedDate(new Date());
      return super.create(picture);
   }
}
