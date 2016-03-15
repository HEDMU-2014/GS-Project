package gs.ejb.beans;

import gs.ejb.domain.Role;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class RoleManager implements RoleManagerLocal, RoleManagerRemote {
   @PersistenceContext
   private EntityManager em;

   @Override
   public Role findRole(int id) {
      return null;
   }

   @Override
   public List<Role> listRoles() {
      return null;
   }

   @Override
   public void createRole(Role role) {

   }

   @Override
   public void updateRole(Role role) {

   }

   @Override
   public void deleteRole(Role role) {

   }
}
