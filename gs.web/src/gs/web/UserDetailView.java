package gs.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.logging.Logger;

import beans.UserBeanLocal;
import domain.Role;
import javafx.scene.input.TouchPoint;

@Named()
@SessionScoped
public class UserDetailView implements Serializable {
	private static final long serialVersionUID = 3193006383857093L;
	@EJB private UserBeanLocal ejb;
	@Inject UserOverviewView overview;
	private Logger logger = Logger.getLogger(UserDetailView.class);
	private String firstname;
	private String lastname;
	private String email;
	private String ct;
	private String tp;
	private List<Role> roles;
	private List<String> rolenames;
	private boolean edit = false;
	
	@PostConstruct
	public void init() {
		realcontacttypes = ctejb.listContactTypes();
		contacttypes = new ArrayList<String>();
		for (ContactType ct : realcontacttypes) {
			contacttypes.add(ct.getCtname());
		}
		realtouchpoints = tpejb.listTouchPoints();
		touchpoints = new ArrayList<String>();
		for (TouchPoint tp : realtouchpoints) {
			touchpoints.add(tp.getTpname());
		}
	}
	
	public void create() {
		logger.info("method create entered");
		try {
			Contact contact = new Contact();
			contact.setEmail(email);
			contact.setSpace(space);
			contact.setSpaceid(space.getSpaceid());
			ContactType contacttype = null;
			for (ContactType ct : realcontacttypes) {
				if (ct.getCtname().equalsIgnoreCase(this.ct)) {
					contacttype = ct;
				}
			}
			contact.setCttype(contacttype);
			contact.setCtid(contacttype.getCtid());
			TouchPoint touchpoint = null;
			for (TouchPoint tp : realtouchpoints) {
				if (tp.getTpname().equalsIgnoreCase(this.tp)) {
					touchpoint = tp;
				}
			}
			contact.setTp(touchpoint);
			contact.setTpid(touchpoint.getTpid());
			ejb.createContact(contact);
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Contact created"));
			overview.init();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Contact allready exists", "Contact allready exists"));
		}
	}
	public void delete() {
		logger.info("method delete entered");
		try {
			ContactId contact = new ContactId();
			contact.setEmail(email);
			contact.setSpaceid(space.getSpaceid());
			ContactType contacttype = null;
			for (ContactType ct : realcontacttypes) {
				if (ct.getCtname().equalsIgnoreCase(this.ct)) {
					contacttype = ct;
				}
			}
			contact.setCtid(contacttype.getCtid());
			TouchPoint touchpoint = null;
			for (TouchPoint tp : realtouchpoints) {
				if (tp.getTpname().equalsIgnoreCase(this.tp)) {
					touchpoint = tp;
				}
			}
			contact.setTpid(touchpoint.getTpid());
			ejb.deleteContact(contact);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Contact deleted"));
			overview.init();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Contact does not exist", "Contact does not exist"));
		}
	}
	
	public boolean isEdit() {
		return edit;
	}
	public void setEdit(boolean edit) {
		this.edit = edit;
	}
	
	public boolean isShowCreate() {
		return !edit;
	}
	public boolean isShowUpdate() {
		return edit;
	}
	public boolean isShowDelete() {
		return edit;
	}

	public Space getSpace() {
		return space;
	}

	public void setSpace(Space space) {
		this.space = space;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCt() {
		return ct;
	}

	public void setCt(String ct) {
		this.ct = ct;
	}

	public String getTp() {
		return tp;
	}

	public void setTp(String tp) {
		this.tp = tp;
	}

	public List<String> getContacttypes() {
		return contacttypes;
	}

	public void setContacttypes(List<String> contacttypes) {
		this.contacttypes = contacttypes;
	}

	public List<String> getTouchpoints() {
		return touchpoints;
	}

	public void setTouchpoints(List<String> touchpoints) {
		this.touchpoints = touchpoints;
	}

}
