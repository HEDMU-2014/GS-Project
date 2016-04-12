package domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class UserProfile implements Serializable {

	private static final long serialVersionUID = 1L;

	private long userid;
//	private User user;
	private String firstname;
	private String lastname;
	private Calendar createddate;
	private Organization organization;
	private char gender;
	private String job;
	private String description;
	private String website;
	private int phone;
	private String education;
	private String location;
	private Country country;
	private String city;
	private String state;
	private Picture profilepicture;

	public long getUserid() {
		return userid;
	}

	public void setUserid(long id) {
		this.userid = id;
	}

//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}

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

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
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

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
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

	public Picture getProfilepicture() {
		return profilepicture;
	}

	public void setProfilepicture(Picture profilepicture) {
		this.profilepicture = profilepicture;
	}

	@Override
	public String toString() {
		SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd" );
		return "UserProfile [userid=" + userid 
//				+ ", user=" + user 
				+ ", firstname=" + firstname + ", lastname=" + lastname
				+ ", createddate=" + formatter.format(createddate.getTime()) 
				+ ", organization=" + organization + ", gender=" + gender + ", job="
				+ job + ", description=" + description + ", website=" + website 
				+ ", phone=" + phone + ", education="
				+ education + ", location=" + location + ", country=" + country 
				+ ", city=" + city
				+ ", state=" + state + ", profilepicture=" + profilepicture	+ "]";
	}


}
