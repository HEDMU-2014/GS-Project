package domain;

import java.util.Calendar;

public class Interest {
    private int interestId;
    private String interestDescription;
    private String interestHeader;
    private long createdBy;
    private Calendar createdDate;

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

	public long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(long createdBy) {
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
		return "Interest [interestId=" + interestId + ", interestDescription=" + interestDescription
				+ ", interestHeader=" + interestHeader + ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ "]";
	}

}
