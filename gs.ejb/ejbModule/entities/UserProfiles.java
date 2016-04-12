package entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import domain.Country;
import domain.Organization;
import domain.Picture;
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
	@OneToOne
	@JoinColumn(name="userid", referencedColumnName="userid")
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
	@JoinColumn(name="profilepicture", referencedColumnName="id")
	private PictureEntity profilepicture;
	@ManyToOne
	@JoinColumn(name="organization")
	private Organizations organization;
	
	public UserProfiles() {
		super();
	}

	public UserProfiles(UserProfile userProfile) {
		getEntityUserProfile(userProfile);
	}
	
	public UserProfiles getEntityUserProfile(UserProfile userProfile){
		
		this.userid=userProfile.getUserid();
//		setUser(new Users().update(userProfile.getUser()));
		setFirstname(userProfile.getFirstname());
		setLastname(userProfile.getLastname());
		setOrganization(new Organizations().update(userProfile.getOrganization()));
		setCreateddate(new Timestamp(userProfile.getCreateddate().getTimeInMillis()));
		setGender(userProfile.getGender());
		setJob(userProfile.getJob());
		setDescription(userProfile.getDescription());
		setWebsite(userProfile.getWebsite());
		setPhone(userProfile.getPhone());
		setEducation(userProfile.getEducation());
		setCountry(new Countries(userProfile.getCountry()));
		setCity(userProfile.getCity());
		setState(userProfile.getState());
		setProfilepicture(new PictureEntity(userProfile.getProfilepicture()));
		return this;
	}
	
	public UserProfile getDomUserProfile(UserProfile prof) {
		prof.setUserid(getUserid());
//		prof.setUser(getUser().map(new User()));
		prof.setFirstname(getFirstname());
		prof.setLastname(getLastname());

		prof.setCreateddate(Calendar.getInstance());
		prof.getCreateddate().setTimeInMillis(getCreateddate().getTime());

		prof.setOrganization(getOrganization().map(new Organization()));
		
		prof.setGender(getGender());
		prof.setJob(getJob());
		prof.setDescription(getDescription());
		prof.setWebsite(getWebsite());
		prof.setPhone(getPhone());
		prof.setEducation(getEducation());
		prof.setCountry(getCountry().map(new Country()));
		prof.setCity(getCity());
		prof.setState(getState());
//		if (getProfilepicture() != null) {
			prof.setProfilepicture(getProfilepicture().map(new Picture()));
//		}
		return prof;
	}

	public long getUserid() {
		return userid;
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

	public PictureEntity getProfilepicture() {
		return profilepicture;
	}

	public void setProfilepicture(PictureEntity profilepicture) {
		this.profilepicture = profilepicture;
	}

	public Organizations getOrganization() {
		return organization;
	}

	public void setOrganization(Organizations organization) {
		this.organization = organization;
	}

	@Override
	public String toString() {
		return "UserProfiles [userid=" + userid + ", user=" + user + ", firstname=" + firstname + ", lastname="
				+ lastname + ", createddate=" + createddate + ", gender=" + gender + ", job=" + job + ", description="
				+ description + ", website=" + website + ", phone=" + phone + ", education=" + education + ", location="
				+ location + ", country=" + country + ", city=" + city + ", state=" + state + ", profilepicture="
				+ profilepicture + ", organization=" + organization + "]";
	}

}
