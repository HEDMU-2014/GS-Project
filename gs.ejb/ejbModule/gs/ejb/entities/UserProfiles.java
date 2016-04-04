package gs.ejb.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import gs.ejb.domain.UserProfile;

@Entity
public class UserProfiles implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userID")
	private Users user;
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

	public UserProfiles() {
		super();
	}

	public UserProfiles(UserProfile userProfile) {
		getEntityUserProfile(userProfile);
	}

	public UserProfiles getEntityUserProfile(UserProfile userProfile) {
		setId(userProfile.getId());
//		setUser(new Users(userProfile.getUser()));
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
//		prof.setUserid(getUserid());
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

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Users getUser() {
		return this.user;
	}

	public void setUser(Users userid) {
		this.user = userid;
	}

	public char getGender() {
		return this.gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
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

}
