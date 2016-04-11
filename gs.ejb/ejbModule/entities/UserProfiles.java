package entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.persistence.*;

import domain.Organization;
import domain.UserProfile;

/**
 * Entity implementation class for Entity: UserProfiles
 *
 */
@Entity

public class UserProfiles implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userID")
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
	private String isocountryid;
	private String city;
	private String state;
	private int profilepictureid;
	private static final long serialVersionUID = 1L;

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
		setId(userProfile.getId());
		
		//TODO: set user from userprofile
//		setUser(new Users().map(userProfile.getUserid()));
		
		this.firstname = userProfile.getFirstname();
		this.lastname = userProfile.getLastname();
		this.organization = new Organizations().update(userProfile.getOrganization());
		this.createddate = new Timestamp(userProfile.getCreateddate().getTimeInMillis());
		
		setGender(userProfile.getGender());
		setJob(userProfile.getJob());
		setDescription(userProfile.getDescription());
		setWebsite(userProfile.getWebsite());
		setPhone(userProfile.getPhone());
		setEducation(userProfile.getEducation());
		setIsocountryid(userProfile.getIsocountryid());
		setCity(userProfile.getCity());
		setState(userProfile.getState());
		setProfilepictureid(userProfile.getProfilepictureid());
		return this;
	}
	
	public UserProfile getDomUserProfile(UserProfile prof) {
		prof.setId(getId());
		prof.setUserid(user.getUserid());
		
		prof.setFirstname(firstname);
		prof.setLastname(lastname);

		prof.setCreateddate(Calendar.getInstance());
		prof.getCreateddate().setTimeInMillis(createddate.getTime());

		prof.setOrganization(organization.map(new Organization()));
		
		prof.setGender(getGender());
		prof.setJob(getJob());
		prof.setDescription(getDescription());
		prof.setWebsite(getWebsite());
		prof.setPhone(getPhone());
		prof.setEducation(getEducation());
		prof.setIsocountryid(getIsocountryid());
		prof.setCity(getCity());
		prof.setState(getState());
		prof.setProfilepictureid(getProfilepictureid());

		return prof;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long l) {
		this.id = l;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public char getGender() {
		return this.gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
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

	public Organizations getOrganization() {
		return organization;
	}

	public void setOrganization(Organizations organization) {
		this.organization = organization;
	}

	public String getJob() {
		return this.job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public int getPhone() {
		return this.phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getIsocountryid() {
		return this.isocountryid;
	}

	public void setIsocountryid(String isocountryid) {
		this.isocountryid = isocountryid;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getProfilepictureid() {
		return this.profilepictureid;
	}

	public void setProfilepictureid(int profilepictureid) {
		this.profilepictureid = profilepictureid;
	}

	@Override
	public String toString() {
		return "UserProfiles [id=" + id + ", user=" + user + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", createddate=" + createddate + ", gender=" + gender + ", job=" + job + ", description="
				+ description + ", website=" + website + ", phone=" + phone + ", education=" + education + ", location="
				+ location + ", isocountryid=" + isocountryid + ", city=" + city + ", state=" + state
				+ ", profilepictureid=" + profilepictureid + ", organization=" + organization + "]";
	}

}
