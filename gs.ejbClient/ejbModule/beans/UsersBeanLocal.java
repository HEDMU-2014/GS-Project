package beans;

import java.util.List;
import java.util.Optional;

import javax.ejb.Local;

import domain.User;

@Local
public interface UsersBeanLocal {
	long create(User user);
	Optional<User> read(long userId);
	Optional<User> read(String email);
	void update(User user);
	void delete(User user);
	List<User> listMembers(String organization);
	List<User> searchUsers(String search);
}
