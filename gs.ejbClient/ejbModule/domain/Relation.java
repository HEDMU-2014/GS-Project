package domain;

import java.io.Serializable;

public class Relation implements Serializable {
	private static final long serialVersionUID = 1L;

	private UserProfile user;
	private UserProfile follower;

	public UserProfile getUser() {
		return user;
	}

	public void setUser(UserProfile user) {
		this.user = user;
	}

	public UserProfile getFollower() {
		return follower;
	}

	public void setFollower(UserProfile follower) {
		this.follower = follower;
	}

	@Override
	public String toString() {
		return "Relation [user=" + user + ", follower=" + follower + "]";
	}


}
