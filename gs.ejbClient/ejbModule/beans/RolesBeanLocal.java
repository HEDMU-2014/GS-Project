package beans;

import javax.ejb.Local;

@Local
public interface RolesBeanLocal {

	public void create(String role);
	public String read(int roleId);
	public void update(int roleId, String role);
	public void delete(int roleId);
}
