package gs.ejb.beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class RoleManager implements RoleManagerLocal, RoleManagerRemote {
   @PersistenceContext
   private EntityManager em;
}
