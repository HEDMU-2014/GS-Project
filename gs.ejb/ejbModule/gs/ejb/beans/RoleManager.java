package gs.ejb.beans;

import gs.ejb.domain.Role;
import gs.ejb.entities.RoleEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class RoleManager implements RoleManagerLocal, RoleManagerRemote {
   @PersistenceContext
   EntityManager em;

   @Override
   public Role findRole(int id) {
      RoleEntity entity = findEntity(id);
      return (entity == null ? null : toDTO(entity));
   }

   @Override
   public List<Role> listRoles() {
      return null;
   }

   @Override
   public void createRole(Role role) {
      RoleEntity entity = new RoleEntity();
      map(role, entity);
      em.persist(entity);
   }

   @Override
   public void updateRole(Role role) {
      RoleEntity entity = findEntity(role.getId());
      if (entity != null)
         map(role, entity);
   }

   @Override
   public void deleteRole(Role role) {
      RoleEntity entity = findEntity(role.getId());
      if (entity != null)
         em.remove(entity);
   }

   private RoleEntity findEntity(int id) {
      return em.find(RoleEntity.class, id);
   }

   private Role toDTO(RoleEntity entity) {
      Role dto = new Role();
      dto.setId(entity.getId());
      dto.setName(entity.getName());
      return dto;
   }

   private void map(Role dto, RoleEntity entity) {
      entity.setName(dto.getName());
   }
}
