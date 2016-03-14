package gs.ejb.beans;

import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import gs.ejb.domain.User;
import gs.ejb.entities.Users;

/**
 * Session Bean implementation class UserBean
 */
@Stateless
public class UserBean implements UserBeanRemote, UserBeanLocal {
	@PersistenceContext
	private EntityManager em;

	public UserBean() {
	}

	@Override
	public void createUser(User user) {
		Users userNew = new Users(user);
		em.persist(userNew);
	}

	@Override
	public Optional<User> readUser(int userID) {
		Users getUser = em.find(Users.class, userID);
		if (getUser != null)
			return Optional.of(getUser.getDomUser(new User()));
		return Optional.empty();
	}

	@Override
	public void updateUser(User user) {
		Users getUser = em.find(Users.class, user.getUserid());
		getUser.getEntityUsers(user);
	}

	@Override
	public void deleteUser(int userID) {
		Users getUser = em.find(Users.class, userID);
		em.remove(getUser);

	}

}
