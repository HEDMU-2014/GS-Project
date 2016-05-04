package gs.web;

import domain.User;

public class UserWrapper {
	private int id;
	private User user;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "UserWrapper [id=" + id + ", user=" + user + "]";
	}

}
