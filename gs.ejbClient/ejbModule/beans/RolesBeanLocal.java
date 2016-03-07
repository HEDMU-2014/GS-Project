package beans;

import java.util.Optional;

import javax.ejb.Local;

import domain.Role;

@Local
public interface RolesBeanLocal {

	public void create(Role role);
	public Optional<Role> read(int roleId);
	public void update(Role role);
	public void delete(Role role);
}
