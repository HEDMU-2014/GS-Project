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
		Users jpaUsers = new Users();
		jpaUsers.setFirstname(user.getFirstname());
		jpaUsers.setLastname(user.getLastname());
		jpaUsers.setEmail(user.getEmail());
		jpaUsers.setCreateddate(user.getCreateddate());
		jpaUsers.setLastlogin(user.getLastlogin());
		jpaUsers.setOrganization(user.getOrganization());
		jpaUsers.setPassword(user.getPassword());
		em.persist(jpaUsers);
	}

	@Override
	public Optional<User> read(int userId) {
		Users jpaUsers = em.find(Users.class, userId);
		if (jpaUsers != null) {
			User user = new User();
			user.setFirstname(jpaUsers.getFirstname());
			user.setLastname(jpaUsers.getLastname());
			user.setEmail(jpaUsers.getEmail());
			user.setCreateddate(jpaUsers.getCreateddate());
			user.setLastlogin(jpaUsers.getLastlogin());
			user.setOrganization(jpaUsers.getOrganization());
			user.setPassword(jpaUsers.getPassword());
			return Optional.of(user);
		}
		else
			return Optional.empty();
	}

	@Override
	public void update(User user) {
		Users jpaUsers = em.find(Users.class, user.getUserid());
		jpaUsers.setFirstname(user.getFirstname());
		jpaUsers.setLastname(user.getLastname());
		jpaUsers.setEmail(user.getEmail());
		jpaUsers.setCreateddate(user.getCreateddate());
		jpaUsers.setLastlogin(user.getLastlogin());
		jpaUsers.setOrganization(user.getOrganization());
		jpaUsers.setPassword(user.getPassword());
	}

	@Override
	public void delete(User user) {
		Roles jpaRoles = em.find(Roles.class, user.getUserid());
		em.remove(jpaRoles);
	}
	
	
}
