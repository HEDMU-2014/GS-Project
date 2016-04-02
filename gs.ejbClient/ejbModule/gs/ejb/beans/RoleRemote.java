package gs.ejb.beans;

import java.util.Optional;

import javax.ejb.Remote;

import gs.ejb.domain.Role;

@Remote
public interface RoleRemote {

    Optional<Role> getRole(int roleid);

    void createRole(Role role);

    void updateRole(Role role);

    void deleteRole(Role role);

}