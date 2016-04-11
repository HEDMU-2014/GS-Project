package beans;

import java.util.List;
import javax.ejb.Local;

import domain.UserPictureComment;


@Local
public interface UserPictureCommentsBeanLocal {

	public void create(UserPictureComment comment);
	public UserPictureComment read(int commentId);
	public void update(UserPictureComment comment);
	public void delete(UserPictureComment comment);
	public List<UserPictureComment> searchCommentsByUserId(long userId);
}
