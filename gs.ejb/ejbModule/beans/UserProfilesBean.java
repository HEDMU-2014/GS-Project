package beans;

import java.util.ArrayList;
import java.util.List;
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
	
	@Override
	public Optional<UserProfile> read(long profileID) {
		UserProfiles userProfile = em.find(UserProfiles.class, profileID);
		if (userProfile != null)
			return Optional.of(userProfile.getDomUserProfile(new UserProfile()));
		return Optional.empty();
	}

	@Override
	public void update(UserProfile profile) {
		UserProfiles userProfile = em.find(UserProfiles.class, profile.getUserid());
		userProfile.getEntityUserProfile(profile);
	}

	@Override
	public List<UserProfile> search(String search) {
		List<UserProfile> users = new ArrayList<>();
		List<UserProfiles> temp = em.createNamedQuery("searchUserProfiles", UserProfiles.class)
				.setParameter("search", "%" + search.toUpperCase() + "%")
				.getResultList();
		
		for (UserProfiles u : temp)
			users.add(u.getDomUserProfile(new UserProfile()));
		
		return users;
	}

}
