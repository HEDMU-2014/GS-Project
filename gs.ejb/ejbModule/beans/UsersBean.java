package beans;

import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.User;
import entities.Roles;
import entities.Users;

@Stateless
public class UsersBean implements UsersBeanRemote, UsersBeanLocal {

	@PersistenceContext EntityManager em;

	@Override
	public void create(User user) {
		Users jpaUsers = new Users(user);
		em.persist(jpaUsers);
	}

	@Override
	public Optional<User> read(int userId) {
		Users user = em.find(Users.class, userId); 
		if (user != null) {
			return Optional.of(user.map(new User()));
		} else {
			return Optional.empty();
		}
	}

	@Override
	public void update(User user) {
		Users jpaUsers = em.find(Users.class, user.getUserid()); 
		if (jpaUsers != null) {
			jpaUsers.update(user);
		} else {
			throw new RuntimeException("User with id " + user.getUserid() + " not found");
		}
	}

	@Override
	public void delete(User user) {
		Roles jpaRoles = em.find(Roles.class, user.getUserid());
		em.remove(jpaRoles);
	}
	
	
}
