package ejb.beans;

import java.util.List;
import java.util.Optional;

import javax.ejb.Remote;

import ejb.domain.User;

@Remote
public interface UserRemote {
	Optional<User> getUser(long userid);

	Optional<User> getUser(String email);

	void createUser(User user);

	void updateUser(User user);

	void deleteUser(User user);

	List<User> listMembers(String organization);

	List<User> searchUsers(String search);

}