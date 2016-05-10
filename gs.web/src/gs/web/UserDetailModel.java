package gs.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import domain.User;

@Named()
@SessionScoped
public class UserDetailModel implements Serializable {
	private static final long serialVersionUID = 1L;
	private User user;
	private boolean edit = false;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public boolean isEdit() {
		return edit;
	}
	public void setEdit(boolean edit) {
		this.edit = edit;
	}
	
	public boolean isNotEdit() {
		return !edit;
	}
	
	public boolean isShowCreate() {
		return edit && user.getUserid() == 0;
	}
	public boolean isShowUpdate() {
		return edit && user.getUserid() > 0;
	}
	public boolean isShowDelete() {
		return user.getUserid() > 0;
	}

}
