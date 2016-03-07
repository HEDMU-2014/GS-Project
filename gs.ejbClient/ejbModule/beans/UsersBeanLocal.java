package beans;

import java.util.Optional;

import javax.ejb.Local;

import domain.User;

@Local
public interface UsersBeanLocal {

	public void create(User user);
	public Optional<User> read(int userId);
	public void update(User user);
	public void delete(User user);
}
