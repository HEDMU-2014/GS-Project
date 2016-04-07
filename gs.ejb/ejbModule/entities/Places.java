package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import domain.Place;

@Entity
public class Places implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(nullable=false, unique=true)
    private int placeId;
    private String placeCity;
    private String placeDescription;
    private String placeIsoCountry;
    private int createdBy;
    private int createdDate;

    public Places() {
        super();
    }

    public Places(Place place) {

    }

    public Places update(Place place) {
        placeId = place.getPlaceId();
        placeCity = place.getPlaceCity();
        placeDescription = place.getPlaceDescription();
        placeIsoCountry = place.getPlaceIsoCountry();
        createdBy = place.getCreatedBy();
        createdDate = place.getCreatedDate();

        return this;
    }

    public Place map(Place place) {
        place.setPlaceId(placeId);
        place.setPlaceCity(placeCity);
        place.setPlaceDescription(placeDescription);
        place.setPlaceIsoCountry(placeIsoCountry);
        place.setCreatedBy(createdBy);
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

    public String getPlaceIsoCountry() {
        return placeIsoCountry;
    }

    public void setPlaceIsoCountry(String placeIsoCountry) {
        this.placeIsoCountry = placeIsoCountry;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public int getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(int createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Places{" +
                "placeId=" + placeId +
                ", placeCity='" + placeCity + '\'' +
                ", placeDescription='" + placeDescription + '\'' +
                ", placeIsoCountry='" + placeIsoCountry + '\'' +
                ", createdBy=" + createdBy +
                ", createdDate=" + createdDate +
                '}';
    }
}
