package gs.web.pictures;

import beans.PictureBeanLocal;

import javax.ejb.EJB;
import javax.ejb.ObjectNotFoundException;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named("pictureDetailsCtrl")
@SessionScoped
public class DetailsController extends ControllerBase implements Serializable {
   public static final String PATH = "/pictures/details.xhtml";
   private static final long serialVersionUID = 1L;

   @Inject
   DetailsModel model;

   @EJB
   private PictureBeanLocal ejb;

   public String create() {
      ejb.create(model.getPicture());
      info("Picture created");
      return overview();
   }

   public String update() {
      try {
         ejb.update(model.getPicture());
         info("Picture updated");
         return overview();
      } catch (ObjectNotFoundException e) {
         error("Picture does not exist");
         return null;
      }
   }

   public String delete() {
      try {
         ejb.delete(model.getPicture());
         info("Picture deleted");
         return overview();
      } catch (ObjectNotFoundException e) {
         error("Picture does not exist");
         return null;
      }
   }

   public boolean canCreate() {
      return (model.getPicture().getId() == null);
   }

   public boolean canUpdate() {
      return (model.getPicture().getId() != null && model.isEditable());
   }

   public boolean canDelete() {
      return canUpdate();
   }

   private String overview() {
      return (OverviewController.PATH + "?faces-redirect=true");
   }
}
