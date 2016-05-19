package entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import domain.Country;
import domain.Place;
import domain.UserProfile;

@Entity
public class Places implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int placeId;
    private String placeCity;
    private String placeDescription;
    @ManyToOne
	@JoinColumn(name="country")
    private Countries placeIsoCountry;
    @ManyToOne
	@JoinColumn(name="createdBy")
    private UserProfiles createdBy;
    private Timestamp createdDate;

    public Places() {
        super();
    }

    public Places(Place place) {
        placeId = place.getPlaceId();
        update(place);
    }

    public Places update(Place place) {
        placeCity = place.getPlaceCity();
        placeDescription = place.getPlaceDescription();
        placeIsoCountry = new Countries(place.getPlaceIsoCountry());
        createdBy = new UserProfiles(place.getCreatedBy());
        createdDate = place.getCreatedDate();

        return this;
    }

    public Place map(Place place) {
        place.setPlaceId(placeId);
        place.setPlaceCity(placeCity);
        place.setPlaceDescription(placeDescription);
        place.setPlaceIsoCountry(placeIsoCountry.map(new Country()));
        place.setCreatedBy(createdBy.map(new UserProfile()));
        place.setCreatedDate(createdDate);

        return place;
    }

    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }

    public String getPlaceCity() {
        return placeCity;
    }

    public void setPlaceCity(String placeCity) {
        this.placeCity = placeCity;
    }

    public String getPlaceDescription() {
        return placeDescription;
    }

    public void setPlaceDescription(String placeDescription) {
        this.placeDescription = placeDescription;
    }

    public Countries getPlaceIsoCountry() {
        return placeIsoCountry;
    }

    public void setPlaceIsoCountry(Countries placeIsoCountry) {
        this.placeIsoCountry = placeIsoCountry;
    }

    public UserProfiles getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserProfiles createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

}
