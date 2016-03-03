package gs.ejb.beans;

import java.util.Optional;

import javax.ejb.Local;

import gs.ejb.domain.Role;

@Local
public interface RoleLocal {

	Optional<Role> getRole(int roleid);

	void createRole(Role role);

	void updateRole(Role role);

	void deleteRole(Role role);

}
