package gs.web;

import java.io.Serializable;

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
	
	public void logout() {
		logger.info("method logout entered");
		try {
			((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).logout();
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}

	public String overview() {
		logger.info("method overview entered");
		return "/admin/useroverview.xhtml";
	}


}
