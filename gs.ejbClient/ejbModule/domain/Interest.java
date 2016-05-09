package domain;


public class Interest {
    private int interestId;
    private String interestDescription;
    private String interestHeader;
    private int userId;
    private int createdBy;
    private int createdDate;

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
