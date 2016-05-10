package beans;

import java.io.Serializable;

/**
 * ID class for entity: Relations
 *
 */ 
public class UserRelationPK  implements Serializable {   
   
	         
	private long user;         
	private long follower; 
	private static final long serialVersionUID = 1L;

	public UserRelationPK() {}

	public long getUser() {
		return this.user;
	}

	public void setUser(long userID) {
		this.user = userID;
	}

	public long getFollower() {
		return follower;
	}

	public void setFollower(long follower) {
		this.follower = follower;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (follower ^ (follower >>> 32));
		result = prime * result + (int) (user ^ (user >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRelationPK other = (UserRelationPK) obj;
		if (follower != other.follower)
			return false;
		if (user != other.user)
			return false;
		return true;
	}

}
