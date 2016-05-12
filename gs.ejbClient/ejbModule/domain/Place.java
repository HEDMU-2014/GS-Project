package domain;


import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Place implements Serializable {
    private static final long serialVersionUID = 1L;

    private int placeId;
    private String placeCity;
    private String placeDescription;
    private Country placeIsoCountry;
    private User createdBy;
    private Calendar createdDate;

    public Place() {}

    public Place(int placeId, String placeCity, String placeDescription, Country placeIsoCountry, User createdBy, Calendar createdDate) {
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

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public Calendar getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Calendar createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd-HH:mm:ss" );
        return "Place{" +
                "placeId=" + placeId +
                ", placeCity='" + placeCity + '\'' +
                ", placeDescription='" + placeDescription + '\'' +
                ", placeIsoCountry='" + placeIsoCountry + '\'' +
                ", createdBy=" + createdBy +
                ", createdDate=" + formatter.format(createdDate.getTime()) +
                '}';
    }
}
