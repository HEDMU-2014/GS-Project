package gs.web;

import beans.PlaceBeanLocal;
import domain.Country;
import domain.User;
import org.jboss.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Calendar;

@Named()
@SessionScoped
public class PlaceDetailControl implements Serializable {

    private static final long serialVersionUID = 3193006383857093L;
    @EJB
    private PlaceBeanLocal ejb;
    @Inject
    private PlaceDetailModel model;
    private Logger logger = Logger.getLogger(this.getClass());

    @PostConstruct
    public void init() {}

    public void create() {
        logger.info("method create entered");
        try {
            model.getPlace().setCreatedBy(new User());
            model.getPlace().setCreatedDate(Calendar.getInstance());
            model.getPlace().setPlaceIsoCountry(new Country());
            //model.getPlace().setPlaceDescription();


            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Place created"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Place already exists", "Place already exists"));
        }
    }

    public void delete() {

    }

    public void update() {

    }
}
