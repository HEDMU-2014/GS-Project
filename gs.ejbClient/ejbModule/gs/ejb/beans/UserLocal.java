package gs.ejb.beans;

import java.util.List;
import java.util.Optional;

import javax.ejb.Local;

import gs.ejb.domain.User;


@Local
public interface UserLocal {

	Optional<User> getUser(long userid);

	Optional<User> getUser(String email);

	void createUser(User user);

	void updateUser(User user);

	void deleteUser(User user);

	List<User> searchUsers(String search);

	List<User> listMembers(String organization);

}
