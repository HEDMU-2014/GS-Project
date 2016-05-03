package gs.web;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;

@Named()
@RequestScoped
public class IndexControl implements Serializable {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(IndexControl.class);
	private String user;
	
	@PostConstruct
	public void init() {
		user = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
	}
	
	public String login() {
		logger.info("method login entered");
		return "/member/index.xhtml";
	}

	public String logout() {
		logger.info("method logout entered");
		try {
			((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).logout();
			user = "unknown";
		} catch (ServletException e) {
			e.printStackTrace();
		}
		return "/index.xhtml";
	}

	public String overview() {
		logger.info("method overview entered");
		return "/admin/useroverview.xhtml";
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	public boolean isAdmin() {
		return FacesContext.getCurrentInstance().getExternalContext().isUserInRole("admin");
	}

}
