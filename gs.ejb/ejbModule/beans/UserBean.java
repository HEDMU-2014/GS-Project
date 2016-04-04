package beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import beans.UserBeanLocal;
import beans.UserBeanRemote;
import domain.User;
import entities.Users;

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
	public Optional<User> readUser(long userID) {
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
	public void deleteUser(long userID) {
		Users getUser = em.find(Users.class, userID);
		em.remove(getUser);
	}

	@Override
	public List<User> listMembers(String organization) {
		List<User> users = new ArrayList<>();
		List<Users> userse = em.createNamedQuery("listMembers", Users.class)
				.setParameter("organization", "%" + organization.toUpperCase() + "%").getResultList();
		for (Users u : userse) {
			users.add(u.getDomUser(new User()));
		}
		return users;
	}

	@Override
	public List<User> searchUsers(String search) {
		List<User> users = new ArrayList<>();
		List<Users> userse = em.createNamedQuery("searchUsers", Users.class)
				.setParameter("search", "%" + search.toUpperCase() + "%").getResultList();
		for (Users u : userse) {
			users.add(u.getDomUser(new User()));
		}
		return users;
	}
}
