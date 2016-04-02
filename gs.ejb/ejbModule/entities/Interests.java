package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import domain.Interest;


@Entity
public class Interests implements Serializable {

    @Id
    private int interestId;
    private String interestDescription;
    private String interestHeader;
    private int userId;
    private int createdBy;
    private int createdDate;
    private static final long serialVersionUID = 1L;

    public Interests() {
        super();
    }

    public Interests(Interest interest) {
        update(interest);
    }

    public Interests update(Interest interest) {
        this.interestId = interest.getInterestId();
        this.interestDescription = interest.getInterestDescription();
        this.interestHeader = interest.getInterestHeader();
        this.userId = interest.getUserId();
        this.createdBy = interest.getCreatedBy();
        this.createdDate = interest.getCreatedDate();
        return this;
    }

    public Interest map(Interest interest) {
        interest.setInterestId(this.interestId);
        interest.setInterestDescription(this.interestDescription);
        interest.setInterestHeader(this.interestHeader);
        interest.setUserId(this.userId);
        interest.setCreatedBy(this.createdBy);
        interest.setCreatedDate(this.createdDate);
        return interest;
    }

    public int getInterestId() {
        return interestId;
    }

    public void setInterestId(int interestId) {
        this.interestId = interestId;
    }

    public String getInterestDescription() {
        return interestDescription;
    }

    public void setInterestDescription(String interestDescription) {
        this.interestDescription = interestDescription;
    }

    public String getInterestHeader() {
        return interestHeader;
    }

    public void setInterestHeader(String interestHeader) {
        this.interestHeader = interestHeader;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
}
