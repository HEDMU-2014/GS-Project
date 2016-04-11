package beans;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.UserPictureComment;
import entities.UserPictureComments;

@Stateless
public class UserPictureCommentsBean implements UserPictureCommentsBeanRemote, UserPictureCommentsBeanLocal {

	@PersistenceContext EntityManager em;
	
	@Override
	public void create(UserPictureComment comment) {
		UserPictureComments jpaUpc = new UserPictureComments(comment);
		em.persist(jpaUpc);
	}

	@Override
	public UserPictureComment read(int commentId) {
		UserPictureComments jpaUpc = em.find(UserPictureComments.class, commentId); 
		if (jpaUpc != null)
			return jpaUpc.map(new UserPictureComment());
		else
			return null;
	}

	@Override
	public void update(UserPictureComment comment) {
		UserPictureComments jpaUpc = em.find(UserPictureComments.class, comment.getId()); 
		if (jpaUpc != null)
			jpaUpc.update(comment);
		else
			throw new RuntimeException("Comment with id " + comment.getId() + " not found");
		
	}

	@Override
	public void delete(UserPictureComment comment) {
		UserPictureComments jpaUpc = em.find(UserPictureComments.class, comment.getId());
		em.remove(jpaUpc);
		
	}

	@Override
	public List<UserPictureComment> searchCommentsByUserId(long id) {
		List<UserPictureComment> upcs = new ArrayList<>();
		List<UserPictureComments> temp = em.createNamedQuery("searchUserPictureComments", UserPictureComments.class)
				.setParameter("search",  id)
				.getResultList();
		
		for (UserPictureComments upc : temp)
			upcs.add(upc.map(new UserPictureComment()));
		
		return upcs;
	}

}
