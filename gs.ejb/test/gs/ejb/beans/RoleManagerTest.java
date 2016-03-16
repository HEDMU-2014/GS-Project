package gs.ejb.beans;

import gs.ejb.domain.Role;
import gs.ejb.entities.RoleEntity;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class RoleManagerTest {
   private RoleManager manager;

   @Before
   public void init() {
      manager = new RoleManager();
      manager.em = mock(EntityManager.class);
   }

   @Test
   public void testFindRole() {
      RoleEntity entity = new RoleEntity();
      entity.setId(1);
      entity.setName("Member");

      when(manager.em.find(RoleEntity.class, 1)).thenReturn(entity);

      Role role = manager.findRole(1);

      assertEquals(1, role.getId());
      assertEquals("Member", role.getName());
   }
}
