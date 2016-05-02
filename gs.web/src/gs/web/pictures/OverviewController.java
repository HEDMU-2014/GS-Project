package gs.web.pictures;

import beans.PictureBeanLocal;
import domain.Picture;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named("picturesOverviewCtrl")
@SessionScoped
public class OverviewController extends ControllerBase implements Serializable {
   public static final String PATH = "/pictures/overview.xhtml";
   private static final long serialVersionUID = 1L;

   @Inject
   OverviewModel model;
   @Inject
   DetailsModel detailsModel;

   @EJB
   private PictureBeanLocal ejb;

   public void listAll() {
      model.setPictures(ejb.listAll());
   }

   public String view() {
      Picture picture = model.getSelectedPicture();

      if (picture == null) {
         info("No row selected");
         return null;
      }

      detailsModel.setPicture(picture);
      detailsModel.setEditable(false);
      return details();
   }

   public String create() {
      detailsModel.setPicture(new Picture());
      detailsModel.setEditable(true);
      return details();
   }

   public String update() {
      Picture picture = model.getSelectedPicture();

      if (picture == null) {
         info("No row selected");
         return null;
      }

      detailsModel.setPicture(picture);
      detailsModel.setEditable(true);
      return details();
   }

   private String details() {
      // Clear selection
      model.setSelectedPicture(null);
      return (DetailsController.PATH + "?faces-redirect=true");
   }
}
