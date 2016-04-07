package beans;

import java.util.Optional;

import domain.UserProfile;

public interface UserProfilesBeanSuper {
public void createUserProfile(UserProfile profile);
public Optional<UserProfile> readUserProfile(int profileID);
public void updateUserProfile(UserProfile profile);
public void deleteUserProfile(UserProfile profile);
}
