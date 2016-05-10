package gs.web;

import beans.PlaceBeanLocal;
import domain.Place;
import org.jboss.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;

@Named()
@SessionScoped
public class PlaceDetailControl implements Serializable {

    @EJB
    private PlaceBeanLocal ejb;
    private Logger logger = Logger.getLogger(this.getClass());

    @PostConstruct
    public void init() {}

    public void create() {
        logger.info("method create entered");
        try {



            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage("Place created")
            );
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Place already exists",
                            "Place already exists")
            );
        }
    }

    public void delete() {

    }

    public void update() {

    }
}
