package gs.ejb.domain;


import java.io.Serializable;

public class Place implements Serializable {
    private static final long serialVersionUID = 1L;

    private int placeId;
    private String placeCity;
    private String placeDescription;
    private String placeIsoCountry;
    private int createdBy;
    private int createdDate;

    public Place() {}

    public Place(int placeId, String placeCity, String placeDescription, String placeIsoCountry, int createdBy, int createdDate) {
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
