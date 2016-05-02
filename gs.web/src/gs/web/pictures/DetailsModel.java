package gs.web.pictures;

import domain.Picture;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named("pictureDetails")
@SessionScoped
public class DetailsModel implements Serializable {
   private static final long serialVersionUID = 1L;

   private Picture picture;
   private boolean editable;

   public Picture getPicture() {
      return picture;
   }

   public void setPicture(Picture picture) {
      this.picture = picture;
   }

   public boolean isEditable() {
      return editable;
   }

   public void setEditable(boolean editable) {
      this.editable = editable;
   }
}
