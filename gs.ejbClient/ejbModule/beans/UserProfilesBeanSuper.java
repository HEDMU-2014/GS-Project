package beans;

import java.util.Optional;

import domain.UserProfile;

public interface UserProfilesBeanSuper {
public void create(UserProfile profile);
public Optional<UserProfile> read(int profileID);
public void update(UserProfile profile);
public void delete(UserProfile profile);
}
