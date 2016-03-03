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
	public Optional<User> getUser(int userid) {
		Users user = em.find(Users.class, userid); 
		if (user != null) {
			return Optional.of(user.map(new User()));
		} else {
			return Optional.empty();
		}
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
	public List<User> listMembers() {
		List<User> users = new ArrayList<>();
		@SuppressWarnings("unchecked")
		List<Users> userse = em.createNamedQuery("listMembers")
				.getResultList();
		for (Users u : userse) {
			users.add(u.map(new User()));
		}
		return users;
	}

	@Override
	public List<User> searchUsers(String search) {
		List<User> users = new ArrayList<>();
		@SuppressWarnings("unchecked")
		List<Users> userse = em.createNamedQuery("searchUsers")
				.setParameter("search", "%" + search.toUpperCase() + "%")
				.getResultList();
		for (Users u : userse) {
			users.add(u.map(new User()));
		}
		return users;
	}
}
