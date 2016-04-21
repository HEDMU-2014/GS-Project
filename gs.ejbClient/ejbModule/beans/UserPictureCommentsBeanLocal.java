package beans;

import java.util.List;
import java.util.Optional;

import javax.ejb.Local;

import domain.UserPictureComment;


@Local
public interface UserPictureCommentsBeanLocal {

	void create(UserPictureComment comment);
	UserPictureComment read(int commentId);
	void update(UserPictureComment comment);
	void delete(UserPictureComment comment);
	List<UserPictureComment> searchCommentsByUserId(long userId);
}
