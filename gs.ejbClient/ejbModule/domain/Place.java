package domain;


import java.io.Serializable;
import java.sql.Timestamp;

public class Place implements Serializable {
    private static final long serialVersionUID = 1L;

    private int placeId;
    private String placeCity;
    private String placeDescription;
    private Country placeIsoCountry;
    private UserProfile createdBy;
    private Timestamp createdDate;

    public Place() {}

    public Place(int placeId, String placeCity, String placeDescription, Country placeIsoCountry, UserProfile createdBy, Timestamp createdDate) {
        this.placeId = placeId;
        this.placeCity = placeCity;
        this.placeDescription = placeDescription;
        this.placeIsoCountry = placeIsoCountry;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
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

    public Country getPlaceIsoCountry() {
        return placeIsoCountry;
    }

    public void setPlaceIsoCountry(Country placeIsoCountry) {
        this.placeIsoCountry = placeIsoCountry;
    }

    public UserProfile getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserProfile createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Place{" +
                "placeId=" + placeId +
                ", placeCity='" + placeCity + '\'' +
                ", placeDescription='" + placeDescription + '\'' +
                ", placeIsoCountry='" + placeIsoCountry + '\'' +
                ", createdBy=" + createdBy +
                ", createdDate=" + createdDate +
                '}';
    }
}
