package gs.ejb.beans;

import java.util.List;
import java.util.Optional;

import javax.ejb.Local;

import gs.ejb.domain.User;


@Local
public interface UserLocal {

	Optional<User> getUser(int userid);

	void createUser(User user);

	void updateUser(User user);

	void deleteUser(User user);

	List<User> listMembers();

	List<User> searchUsers(String search);

}
