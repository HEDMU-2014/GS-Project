package entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

import domain.Interest;
import domain.User;

@Entity
public class Interests implements Serializable {

    @Id
    @Column(nullable = false, unique = true)
    private int interestId;
    private String interestDescription;
    private String interestHeader;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE} )
    @PrimaryKeyJoinColumn(name = "userId", referencedColumnName = "userId")
    private Users userId;
    @OneToOne
    private Users createdBy;
    private Timestamp createdDate;
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
        this.userId = new Users().update(interest.getUserId());
        this.createdBy = new Users().update(interest.getCreatedBy());
        this.createdDate = interest.getCreatedDate();
        return this;
    }

    public Interest map(Interest interest) {
        interest.setInterestId(this.interestId);
        interest.setInterestDescription(this.interestDescription);
        interest.setInterestHeader(this.interestHeader);
        interest.setUserId(userId.map(new User()));
        interest.setCreatedBy(createdBy.map(new User()));
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

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    public Users getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Users createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }
}
