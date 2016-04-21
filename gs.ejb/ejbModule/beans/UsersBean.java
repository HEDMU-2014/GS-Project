package beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.User;
import entities.Users;

@Stateless
public class UsersBean implements UsersBeanLocal {

	@PersistenceContext EntityManager em;

	@Override
	public long create(User user) {
		Users jpaUsers = new Users(user);
		em.persist(jpaUsers);
		return jpaUsers.getUserid();
	}

	@Override
	public Optional<User> read(long userId) {
		Users user = em.find(Users.class, userId); 
		if (user != null)
			return Optional.of(user.map(new User()));
		else
			return Optional.empty();
	}

	@Override
	public Optional<User> read(String email) {
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
	public void update(User user) {
		Users jpaUsers = em.find(Users.class, user.getUserid()); 
		if (jpaUsers != null)
			jpaUsers.update(user);
		else
			throw new RuntimeException("User with id " + user.getUserid() + " not found");
	}

	@Override
	public void delete(User user) {
		Users jpaUsers = em.find(Users.class, user.getUserid());
		em.remove(jpaUsers);
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
