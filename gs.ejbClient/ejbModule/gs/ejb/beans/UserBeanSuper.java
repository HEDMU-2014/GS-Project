package gs.ejb.beans;

import java.util.List;
import java.util.Optional;

import gs.ejb.domain.User;

public interface UserBeanSuper {

	public void createUser(User user);

	public Optional<User> readUser(long userID);

	public void updateUser(User user);

	public void deleteUser(long userID);

	public List<User> listMembers(String organization);

	public List<User> searchUsers(String search);
}
