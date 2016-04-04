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
		// TODO Auto-generated constructor stub
	}

	public PictureEntity update(Picture coverPicture) {
		// TODO Auto-generated method stub
		return null;
	}

	public Picture map(Picture picture) {
		// TODO Auto-generated method stub
		return null;
	}

}
