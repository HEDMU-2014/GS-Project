package entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import domain.Interest;


@Entity
public class Interests implements Serializable {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int interestId;
    private String interestDescription;
    private String interestHeader;
    @ManyToOne
    @JoinColumn(name="userid", referencedColumnName="userid")
    private UserProfiles createdBy;
    private Timestamp createdDate;
    private static final long serialVersionUID = 1L;

    public Interests() {
        super();
    }

    public Interests(Interest interest) {
        this.interestId = interest.getInterestId();
        update(interest);
    }

    public Interests update(Interest interest) {
        this.interestDescription = interest.getInterestDescription();
        this.interestHeader = interest.getInterestHeader();
        this.createdBy = new UserProfiles();
        this.createdBy.setUserid(interest.getCreatedBy());
        this.createdDate = new Timestamp(interest.getCreatedDate().getTimeInMillis());
        return this;
    }

    public Interest map(Interest interest) {
        interest.setInterestId(this.interestId);
        interest.setInterestDescription(this.interestDescription);
        interest.setInterestHeader(this.interestHeader);
        interest.setCreatedBy(this.createdBy.getUserid());
        interest.setCreatedDate(Calendar.getInstance());
        interest.getCreatedDate().setTimeInMillis(getCreatedDate().getTime());
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

	public UserProfiles getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(UserProfiles createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

}
