package gs.ejb.beans;

import gs.ejb.domain.Role;

public interface RoleBeanSuper {
void createRole(int roleID, String role);
Role readRole(int roleID);
void updateRole(int roleID, String role);
void deleteRole(int roleID);
}
