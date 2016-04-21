package beans;

import java.util.List;
import java.util.Optional;

import domain.UserProfile;

public interface UserProfilesBeanSuper {
Optional<UserProfile> readUserProfile(int profileID);
void updateUserProfile(UserProfile profile);
List<UserProfile> searchUserProfiles(String search);
}
