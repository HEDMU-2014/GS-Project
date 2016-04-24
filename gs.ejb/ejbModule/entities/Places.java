package entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

import domain.Country;
import domain.Place;
import domain.User;

@Entity
@NamedQueries({
        @NamedQuery(name = "searchPlaces",
                query = "SELECT p FROM Places p  "
                        + "WHERE UPPER(p.placeCity) LIKE :search "
                        + "OR UPPER(p.placeIsoCountry.countryname) LIKE :search "
                        + "ORDER BY p.placeCity")
})

public class Places implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(nullable=false, unique=true)
    private int placeId;
    private String placeCity;
    private String placeDescription;
    @ManyToOne
    private Countries placeIsoCountry;
    @ManyToOne
    private Users createdBy;
    private Date createdDate;

    public Places() {
        super();
    }

    public Places(Place place) {
        update(place);
    }

    public Places update(Place place) {
        placeId = place.getPlaceId();
        placeCity = place.getPlaceCity();
        placeDescription = place.getPlaceDescription();
        placeIsoCountry = new Countries(place.getPlaceIsoCountry());
        createdBy = new Users(place.getCreatedBy());
        createdDate = place.getCreatedDate();

        return this;
    }

    public Place map(Place place) {
        place.setPlaceId(placeId);
        place.setPlaceCity(placeCity);
        place.setPlaceDescription(placeDescription);
        place.setPlaceIsoCountry(placeIsoCountry.map(new Country()));
        place.setCreatedBy(createdBy.map(new User()));
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

    public Users getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Users createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
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
