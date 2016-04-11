package beans;

import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.UserProfile;
import entities.UserProfiles;

/**
 * Session Bean implementation class UserProfilesBean
 */
@Stateless
public class UserProfilesBean implements UserProfilesBeanRemote, UserProfilesBeanLocal {

	@PersistenceContext
	private EntityManager em;
	
    public UserProfilesBean() {
    }

	@Override
	public void create(UserProfile profile) {
		UserProfiles profiles = new UserProfiles(profile);
		em.persist(profiles);
	}

	@Override
	public Optional<UserProfile> read(int profileID) {
		UserProfiles userProfile = em.find(UserProfiles.class, profileID);
		if (userProfile != null)
			return Optional.of(userProfile.getDomUserProfile(new UserProfile()));
		return Optional.empty();
	}

	@Override
	public void update(UserProfile profile) {
		UserProfiles userProfile = em.find(UserProfiles.class, profile.getId());
		userProfile.getEntityUserProfile(profile);
	}

	@Override
	public void delete(UserProfile profile) {
		UserProfiles userProfile = em.find(UserProfiles.class, profile.getId());
		em.remove(userProfile);
	}

}
