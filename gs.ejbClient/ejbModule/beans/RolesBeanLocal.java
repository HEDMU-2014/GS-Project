package beans;

import java.util.Optional;

import javax.ejb.Local;

import domain.Role;

@Local
public interface RolesBeanLocal {

	void create(Role role);
	Optional<Role> read(int roleId);
	void update(Role role);
	void delete(Role role);
}
