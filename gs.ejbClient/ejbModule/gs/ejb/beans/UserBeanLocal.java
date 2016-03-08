package gs.ejb.beans;

import java.util.Optional;

import javax.ejb.Local;

import gs.ejb.domain.User;

@Local
public interface UserBeanLocal {
	public void createUser(String firstName, String lastName, String email, String password, String organisation);

	public Optional<User> readUser(int userID);

	public void updateUser(User user);

	public void deleteUser(int userID);
}
