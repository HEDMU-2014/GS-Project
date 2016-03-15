package gs.ejb.beans;

import java.util.ArrayList;
import java.util.List;
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
public class UserBean implements UserRemote, UserLocal {
	@PersistenceContext private EntityManager em;

	@Override
	public Optional<User> getUser(long userid) {
		Optional<User> opt = Optional.empty();
		Users user = em.find(Users.class, userid); 
		if (user != null) {
			opt = Optional.of(user.map(new User()));
		}
		return opt;
	}

	@Override
	public Optional<User> getUser(String email) {
		Optional<User> opt = Optional.empty();
		List<Users> userse = em.createNamedQuery("getUserFromEmail", Users.class)
				.setParameter("email", email.toUpperCase())
				.getResultList();
		if (userse.size() == 1) {
			opt = Optional.of(userse.get(0).map(new User()));
		}
		return opt;
	}
	
	@Override
	public void createUser(User user) {
		Users entity = new Users(user);
		em.persist(entity);
	}
	
	@Override
	public void updateUser(User user) {
		Users users = em.find(Users.class, user.getUserid()); 
		if (users != null) {
			users.update(user);
		} else {
			throw new RuntimeException("User with id " + user.getUserid() + " not found");
		}
	}
	
	@Override
	public void deleteUser(User user) {
		Users users = em.find(Users.class, user.getUserid()); 
		if (users != null) {
			em.remove(users);
		} else {
			throw new RuntimeException("User with id " + user.getUserid() + " not found");
		}
	}
	
	@Override
	public List<User> listMembers(String organization) {
		List<User> users = new ArrayList<>();
		List<Users> userse = em.createNamedQuery("listMembers", Users.class)
				.setParameter("organization", "%" + organization.toUpperCase() + "%")
				.getResultList();
		for (Users u : userse) {
			users.add(u.map(new User()));
		}
		return users;
	}

	@Override
	public List<User> searchUsers(String search) {
		List<User> users = new ArrayList<>();
		List<Users> userse = em.createNamedQuery("searchUsers", Users.class)
				.setParameter("search", "%" + search.toUpperCase() + "%")
				.getResultList();
		for (Users u : userse) {
			users.add(u.map(new User()));
		}
		return users;
	}
}
