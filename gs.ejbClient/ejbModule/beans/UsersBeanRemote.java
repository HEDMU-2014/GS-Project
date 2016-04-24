package beans;

import domain.User;

import javax.ejb.Remote;
import java.util.List;
import java.util.Optional;

@Remote
public interface UsersBeanRemote {

    public long create(User user);
    public Optional<User> read(long userId);
    public Optional<User> read(String email);
    public void update(User user);
    public void delete(User user);
    public List<User> listMembers(String organization);
    public List<User> searchUsers(String search);
}
