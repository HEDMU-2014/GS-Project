package beans;

import java.util.List;
import java.util.Optional;

import javax.ejb.Local;

import domain.User;

@Local
public interface UsersBeanLocal {

	public long create(User user);
	public Optional<User> read(long userId);
	public Optional<User> read(String email);
	public void update(User user);
	public void delete(User user);
	public List<User> listMembers(String organization);
}
