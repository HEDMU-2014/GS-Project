package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

import domain.HasId;

/**
 * Entity implementation class for Entity: UserAlbums
 *
 */
@Entity
@NamedQueries({
		@NamedQuery(name = Pictures.listAll, query = "SELECT p FROM Pictures p")
})
public class Pictures implements HasId<Long>, Serializable {
	public static final String listAll = "Pictures.listAll";

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "pictureId")
	private Long id;

	@NotNull
	private String imgUrl;

	@Column(length=200)
	private String caption;

	// TODO: Restore NotNull constraint
	// Temporarily allow userProfile to be null
	//@NotNull
	@ManyToOne
	@JoinColumn(name="userProfileId")
	private UserProfiles userProfile;

	@NotNull
	private Date createdDate;

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public UserProfiles getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfiles user) {
		this.userProfile = user;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}
