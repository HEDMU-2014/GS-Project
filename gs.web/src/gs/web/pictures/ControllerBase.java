package gs.web.pictures;

import org.jboss.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public abstract class ControllerBase {
   protected Logger logger;

   protected ControllerBase() {
      logger = Logger.getLogger(getClass());
   }

   protected static void info(String summary) {
      message(FacesMessage.SEVERITY_INFO, summary);
   }

   protected static void error(String summary) {
      message(FacesMessage.SEVERITY_ERROR, summary);
   }

   protected static void message(FacesMessage.Severity severity, String summary) {
      message(severity, summary, null);
   }

   protected static void message(FacesMessage.Severity severity, String summary, String detail) {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
   }
}
