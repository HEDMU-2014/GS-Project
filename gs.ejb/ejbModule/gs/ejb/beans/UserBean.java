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
	public void createUser(String firstName, String lastName, String email, String password, String organisation) {
		Users userNew = new Users();
		userNew.setFirstName(firstName);
		userNew.setLastName(lastName);
		userNew.setEmail(email);
		userNew.setPassword(password);
		userNew.setOrganisation(organisation);
		em.persist(userNew);
	}

	@Override
	public Optional<User> readUser(int userID) {
		Users getUser = em.find(Users.class, userID);
		if (getUser != null)
			return Optional.of(getUser.getDomUser());
		return Optional.empty();
	}

	@Override
	public void updateUser(User user) {
		Users getUser = em.find(Users.class, user.getUserid());
		getUser.setCreatedDate(user.getCreateddate());
		getUser.setEmail(user.getEmail());
		getUser.setFirstName(user.getFirstname());
		getUser.setLastLogin(user.getLastlogin());
		getUser.setLastName(user.getLastname());
		getUser.setOrganisation(user.getOrganization());
		getUser.setPassword(user.getPassword());
	}

	@Override
	public void deleteUser(int userID) {
		Users getUser = em.find(Users.class, userID);
		em.remove(getUser);

	}

}
