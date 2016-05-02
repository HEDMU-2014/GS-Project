package gs.web.pictures;

import domain.Picture;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("picturesOverview")
@SessionScoped
public class OverviewModel implements Serializable {
   private static final long serialVersionUID = 1L;

   private List<Picture> pictures;
   private Picture selectedPicture;

   public List<Picture> getPictures() {
      return pictures;
   }

   public void setPictures(List<Picture> pictures) {
      this.pictures = pictures;
   }

   public Picture getSelectedPicture() {
      return selectedPicture;
   }

   public void setSelectedPicture(Picture picture) {
      selectedPicture = picture;
   }
}
