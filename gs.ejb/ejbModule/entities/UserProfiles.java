package entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import domain.UserProfile;

/**
 * Entity implementation class for Entity: UserProfiles
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "searchUserProfiles", 
	query = "SELECT p FROM UserProfiles p, Users u  "
		+ "WHERE UPPER(p.firstname) LIKE :search "
		+ "OR UPPER(p.lastname) LIKE :search "
		+ "OR UPPER(u.email) LIKE :search "
		+ "OR UPPER(p.organization.name) LIKE :search "
		+ "ORDER BY p.lastname")
	})

public class UserProfiles implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long userid;
	@MapsId
	@OneToOne(mappedBy="userprofile")
	@JoinColumn(name="userid")
	private Users user;
	private String firstname;
	private String lastname;
	private Timestamp createddate;
	private char gender;
	private String job;
	private String description;
	private String website;
	private int phone;
	private String education;
	private String location;
	@ManyToOne
	@JoinColumn(name="country", referencedColumnName="countrycode")
	private Countries country;
	private String city;
	private String state;
	@ManyToOne
	@JoinColumn(name="profilepicture", referencedColumnName="pictureId")
	private Pictures profilepicture;
	@ManyToOne
	@JoinColumn(name="organization", referencedColumnName="orgId")
	private Organizations organization;
	
	public UserProfiles() {
		super();
	}

	public UserProfiles(UserProfile userProfile) {
		getEntityUserProfile(userProfile);
	}
	
	public UserProfiles getEntityUserProfile(UserProfile userProfile){
		
		this.userid=userProfile.getUserid();
		setUser(new Users());
		getUser().setUserid(userProfile.getUserid());
		setFirstname(userProfile.getFirstname());
		setLastname(userProfile.getLastname());
		if (userProfile.getOrgId() > 0) {
			setOrganization(new Organizations());
			getOrganization().setOrgId(userProfile.getOrgId());
		}
		setCreateddate(new Timestamp(userProfile.getCreateddate().getTimeInMillis()));
		setGender(userProfile.getGender());
		setJob(userProfile.getJob());
		setDescription(userProfile.getDescription());
		setWebsite(userProfile.getWebsite());
		setPhone(userProfile.getPhone());
		setEducation(userProfile.getEducation());
		if (userProfile.getCountrycode() != null) {
			setCountry(new Countries());
			getCountry().setCountrycode(userProfile.getCountrycode());
		}
		setCity(userProfile.getCity());
		setState(userProfile.getState());
		if (userProfile.getProfilepictureId() >0) {
			setProfilepicture(new Pictures());
			getProfilepicture().setPictureId(userProfile.getProfilepictureId());
		}
		return this;
	}
	
	public UserProfile getDomUserProfile(UserProfile prof) {
		prof.setUserid(getUser().getUserid());
		prof.setFirstname(getFirstname());
		prof.setLastname(getLastname());
		prof.setEmail(getUser().getEmail());

		prof.setCreateddate(Calendar.getInstance());
		prof.getCreateddate().setTimeInMillis(getCreateddate().getTime());
		if (getOrganization() != null) {
			prof.setOrgId(getOrganization().getOrgId());
		}
		prof.setGender(getGender());
		prof.setJob(getJob());
		prof.setDescription(getDescription());
		prof.setWebsite(getWebsite());
		prof.setPhone(getPhone());
		prof.setEducation(getEducation());
		if (getCountry() != null) {
			prof.setCountrycode(getCountry().getCountrycode());
		}
		prof.setCity(getCity());
		prof.setState(getState());
		if (getProfilepicture() != null) {
			prof.setProfilepictureId(getProfilepicture().getPictureId());
		}
		return prof;
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Timestamp getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Timestamp createddate) {
		this.createddate = createddate;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Countries getCountry() {
		return country;
	}

	public void setCountry(Countries country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Pictures getProfilepicture() {
		return profilepicture;
	}

	public void setProfilepicture(Pictures profilepicture) {
		this.profilepicture = profilepicture;
	}

	public Organizations getOrganization() {
		return organization;
	}

	public void setOrganization(Organizations organization) {
		this.organization = organization;
	}

}
