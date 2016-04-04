package domain;

import java.io.Serializable;

public class UserProfile implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private long userid;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
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

	public String getIsocountryid() {
		return isocountryid;
	}

	public void setIsocountryid(String isocountryid) {
		this.isocountryid = isocountryid;
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

	public int getProfilepictureid() {
		return profilepictureid;
	}

	public void setProfilepictureid(int profilepictureid) {
		this.profilepictureid = profilepictureid;
	}

	@Override
	public String toString() {
		return "UserProfile [id=" + id + ", userid=" + userid + ", gender=" + gender + ", job=" + job + ", description="
				+ description + ", website=" + website + ", phone=" + phone + ", education=" + education + ", location="
				+ location + ", isocountryid=" + isocountryid + ", city=" + city + ", state=" + state
				+ ", profilepictureid=" + profilepictureid + "]";
	}

}
