package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import domain.Picture;

/**
 * Entity implementation class for Entity: UserAlbums
 *
 */
@Entity

public class PictureEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	//Dummy entity class
	
	public PictureEntity() {
		
	}
	
	public PictureEntity(Picture picture) {
		this.id = (int) picture.getId();
	}

	public PictureEntity update(Picture coverPicture) {
		this.id = (int) coverPicture.getId();
		return this;
	}

	public Picture map(Picture picture) {
		picture.setId(id);
		return picture;
	}

}
