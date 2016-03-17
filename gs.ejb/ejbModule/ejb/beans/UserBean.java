package ejb.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ejb.domain.User;
import ejb.entities.UserEntity;

/**
 * Session Bean implementation class UserBean
 */
@Stateless
public class UserBean implements UserRemote, UserLocal {
	@PersistenceContext private EntityManager em;

	@Override
	public Optional<User> getUser(long userid) {
		Optional<User> opt = Optional.empty();
		UserEntity user = em.find(UserEntity.class, userid); 
		if (user != null) {
			opt = Optional.of(user.map(new User()));
		}
		return opt;
	}

	@Override
	public Optional<User> getUser(String email) {
		Optional<User> opt = Optional.empty();
		List<UserEntity> userse = em.createNamedQuery("getUserFromEmail", UserEntity.class)
				.setParameter("email", email.toUpperCase())
				.getResultList();
		if (userse.size() == 1) {
			opt = Optional.of(userse.get(0).map(new User()));
		}
		return opt;
	}
	
	@Override
	public void createUser(User user) {
		UserEntity entity = new UserEntity(user);
		em.persist(entity);
	}
	
	@Override
	public void updateUser(User user) {
		UserEntity users = em.find(UserEntity.class, user.getUserid()); 
		if (users != null) {
			users.update(user);
		} else {
			throw new RuntimeException("User with id " + user.getUserid() + " not found");
		}
	}
	
	@Override
	public void deleteUser(User user) {
		UserEntity users = em.find(UserEntity.class, user.getUserid()); 
		if (users != null) {
			em.remove(users);
		} else {
			throw new RuntimeException("User with id " + user.getUserid() + " not found");
		}
	}
	
	@Override
	public List<User> listMembers(String organization) {
		List<User> users = new ArrayList<>();
		List<UserEntity> userse = em.createNamedQuery("listMembers", UserEntity.class)
				.setParameter("organization", "%" + organization.toUpperCase() + "%")
				.getResultList();
		for (UserEntity u : userse) {
			users.add(u.map(new User()));
		}
		return users;
	}

	@Override
	public List<User> searchUsers(String search) {
		List<User> users = new ArrayList<>();
		List<UserEntity> userse = em.createNamedQuery("searchUsers", UserEntity.class)
				.setParameter("search", "%" + search.toUpperCase() + "%")
				.getResultList();
		for (UserEntity u : userse) {
			users.add(u.map(new User()));
		}
		return users;
	}
}