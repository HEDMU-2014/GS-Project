package gs.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import domain.Organization;
import domain.Picture;
import domain.Role;
import domain.User;
import domain.UserProfile;

@Named
@SessionScoped
public class UserProfileModel implements Serializable {
	
	private User user;
	private UserProfile userProfile;
	private Role role;
	private Organization org;
	private Picture picture;
	private boolean edit = false;
	private int[] selectedRoles;
	private String selectedCountry;
	private static final long serialVersionUID = 1L;

	public boolean isEdit() {
		return edit;
	}
	public void setEdit(boolean edit) {
		this.edit = edit;
	}
	
	public boolean isNotEdit() {
		return !edit;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public boolean isShowUpdate() {
		return edit && user.getUserid() > 0;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Organization getOrg() {
		return org;
	}
	public void setOrg(Organization org) {
		this.org = org;
	}
	public Picture getPicture() {
		return picture;
	}
	public void setPicture(Picture picture) {
		this.picture = picture;
	}
	public int[] getSelectedRoles() {
		return selectedRoles;
	}
	public void setSelectedRoles(int[] selectedRoles) {
		this.selectedRoles = selectedRoles;
	}
	public String getSelectedCountry() {
		return selectedCountry;
	}
	public void setSelectedCountry(String selectedCountry) {
		this.selectedCountry = selectedCountry;
	}
	
}
