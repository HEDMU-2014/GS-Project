package gs.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.logging.Logger;

import beans.UserBeanLocal;
import domain.User;

@Named
@SessionScoped
public class UserOverviewView implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB private UserBeanLocal ejb;
	@Inject UserDetailView detail;
	private Logger logger = Logger.getLogger(UserOverviewView.class);
	private List<UserWrapper> users;
	private UserWrapper selectedUser;
	
	public void init() {
		List<User> users = ejb.searchUsers("");
		this.users = new ArrayList<UserWrapper>();
		int i=0;
		for (User user : users) {
			UserWrapper uw = new UserWrapper();
			uw.setId(i++);
			uw.setUser(user);
			this.users.add(uw);
		}
	}

	public String view() {
		logger.info("Selected user : " + selectedUser);
		if (this.selectedUser != null && detail != null) {
			detail.setEmail(this.selectedContact.getContact().getEmail());
			detail.setCt(this.selectedContact.getContact().getCttype().getCtname());
			detail.setTp(this.selectedContact.getContact().getTp().getTpname());
			detail.setEdit(true);
			detail.init();
			this.selectedContact = null;
			return "/contactdetail.xhtml";
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No row selected"));
		return null;
	}

	public String create() {
		if (detail != null) {
			detail.setSpace(this.space);
			detail.setEmail(null);
			detail.setCt(null);
			detail.setTp(null);
			this.selectedContact = null;
			detail.setEdit(false);
			detail.init();
			this.selectedContact = null;
			return "/contactdetail.xhtml";
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Something very wrong"));
		return null;
	}

	public List<UserWrapper> getContacts() {
		return contacts;
	}

	public void setContacts(List<UserWrapper> contacts) {
		this.contacts = contacts;
	}

	public UserWrapper getSelectedContact() {
		return selectedContact;
	}

	public void setSelectedContact(UserWrapper selectedContact) {
		this.selectedContact = selectedContact;
	}

	public Space getSpace() {
		return space;
	}

	public void setSpace(Space space) {
		this.space = space;
	}
	



	
}
