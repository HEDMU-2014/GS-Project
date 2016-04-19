package domain;

import java.sql.Timestamp;

public class Interest {
    private int interestId;
    private String interestDescription;
    private String interestHeader;
    private User userId;
    private User createdBy;
    private Timestamp createdDate;

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

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
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
        return "Interest{" +
                "interestId=" + interestId +
                ", interestDescription='" + interestDescription + '\'' +
                ", interestHeader='" + interestHeader + '\'' +
                ", userId=" + userId +
                ", createdBy=" + createdBy +
                ", createdDate=" + createdDate +
                '}';
    }
}
