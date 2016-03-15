package gs.ejb.beans;

import gs.ejb.domain.Role;

import java.util.List;

public interface RoleManagerCommon {
   Role findRole(int id);

   List<Role> listRoles();

   void createRole(Role role);

   void updateRole(Role role);

   void deleteRole(Role role);
}
