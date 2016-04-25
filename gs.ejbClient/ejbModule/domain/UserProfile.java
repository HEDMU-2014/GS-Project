package domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class UserProfile implements Serializable {

	private static final long serialVersionUID = 1L;

	private long userid;
	private String firstname;
	private String lastname;
	private String email;
	private Calendar createddate;
	private int orgId;
	private char gender;
	private String job;
	private String description;
	private String website;
	private int phone;
	private String education;
	private String location;
	private String countrycode;
	private String city;
	private String state;
	private long profilepictureId;

	public long getUserid() {
		return userid;
	}

	public void setUserid(long id) {
		this.userid = id;
	}

	public char getGender() {
		return gender;
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

	public Calendar getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Calendar createddate) {
		this.createddate = createddate;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getOrgId() {
		return orgId;
	}

	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}

	public String getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}

	public long getProfilepictureId() {
		return profilepictureId;
	}

	public void setProfilepictureId(long profilepictureId) {
		this.profilepictureId = profilepictureId;
	}

	@Override
	public String toString() {
		SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd" );
		return "UserProfile [userid=" + userid 
				+ ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", createddate=" + formatter.format(createddate.getTime()) 
				+ ", organization=" + orgId + ", gender=" + gender + ", job="
				+ job + ", description=" + description + ", website=" + website 
				+ ", phone=" + phone + ", education="
				+ education + ", location=" + location + ", country=" + countrycode 
				+ ", city=" + city
				+ ", state=" + state + ", profilepicture=" + profilepictureId	+ "]";
	}

}
