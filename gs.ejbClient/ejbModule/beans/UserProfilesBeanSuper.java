package beans;

import java.util.List;
import java.util.Optional;

import domain.UserProfile;

public interface UserProfilesBeanSuper {
public Optional<UserProfile> read(long profileID);
public void update(UserProfile profile);
public List<UserProfile> search(String search);
}
