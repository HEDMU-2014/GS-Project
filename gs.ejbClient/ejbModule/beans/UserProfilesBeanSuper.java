package beans;

import java.util.List;
import java.util.Optional;

import domain.UserProfile;

public interface UserProfilesBeanSuper {
public Optional<UserProfile> readUserProfile(int profileID);
public void updateUserProfile(UserProfile profile);
public List<UserProfile> searchUserProfiles(String search);
}
