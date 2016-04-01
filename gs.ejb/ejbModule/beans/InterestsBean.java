package beans;

import java.util.Optional;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.Interest;
import entities.Interests;

@Stateless
@LocalBean
public class InterestsBean implements InterestsBeanRemote, InterestsBeanLocal {

    @PersistenceContext EntityManager em;

    public void create(Interest interest) {
        Interests interests = new Interests(interest);
        em.persist(interests);
    }

    public Optional<Interest> read(int roleId) {
        Interests interests = em.find(Interests.class, roleId);
        if (interests != null) {
            return Optional.of(interests.map(new Interest()));
        } else {
            return Optional.empty();
        }
    }

    public void update(Interest interest) {
        Interests interests = em.find(Interests.class, interest.getInterestId());
        if (interests != null) {
            interests.update(interest);
        } else {
            throw new RuntimeException("Interest with id " + interest.getInterestId() + " not found");
        }
    }

    public void delete(Interest interest) {
        Interests interests = em.find(Interests.class, interest.getInterestId());
        if (interests != null) {
            em.remove(interests);
        } else {
            throw new RuntimeException("Interest with id " + interest.getInterestId() + " not found");
        }
    }
}

