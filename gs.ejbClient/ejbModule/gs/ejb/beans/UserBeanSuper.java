package gs.ejb.beans;

import java.util.Collection;
import java.util.Optional;

import gs.ejb.domain.Role;
import gs.ejb.domain.User;

public interface UserBeanSuper {

	public void createUser(User user);

	public Optional<User> readUser(int userID);

	public void updateUser(User user);

	public void deleteUser(int userID);
}
