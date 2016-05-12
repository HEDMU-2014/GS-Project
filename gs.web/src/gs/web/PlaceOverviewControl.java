package gs.web;

import beans.PlaceBeanLocal;
import domain.Country;
import domain.Place;
import org.jboss.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class PlaceOverviewControl implements Serializable {

    private static final long serialVersionUID = 1L;
    @EJB
    private PlaceBeanLocal ejb;
    @Inject
    private PlaceOverviewModel model;
    @Inject
    private PlaceDetailModel detail;
    private Logger logger = Logger.getLogger(PlaceOverviewControl.class);
    private final String REDIRECT_DETAIL = "/placedetail.xhtml";


    @PostConstruct
    public void init() {}

    public void search() {
        logger.info("Search : " + model.getSearchstring());
        List<Place> places = ejb.searchPlaces(model.getSearchstring());
        model.setPlaces(new ArrayList<>());
        int i = 0;
        for (Place place : places) {
            PlaceWrapper pw = new PlaceWrapper();
            pw.setId(i++);
            pw.setPlace(place);
            model.getPlaces().add(pw);
        }
    }

    public String view() {
        logger.info("Selected place : " + model.getSelectedPlace());
        if (model.getSelectedPlace() != null && detail != null) {
            detail.setPlace(model.getSelectedPlace().getPlace());
            detail.setEditable(false);
            model.setSelectedPlace(null);
            return REDIRECT_DETAIL;
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No row selected"));
            return null;
        }
    }

    public String update() {
        logger.info("Selected place : " + model.getSelectedPlace());
        if (model.getSelectedPlace() != null && detail != null) {
            detail.setPlace(model.getSelectedPlace().getPlace());
            detail.setEditable(true);
            model.setSelectedPlace(null);
            return REDIRECT_DETAIL;
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No row selected"));
            return null;
        }
    }

    public String create() {
        if (detail != null && FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal() != null) {
            detail.setPlace(new Place());
            detail.getPlace().setPlaceIsoCountry(new Country());
            detail.setEditable(true);
            model.setSelectedPlace(null);
            return REDIRECT_DETAIL;
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Something very wrong"));
            return null;
        }
    }
}
