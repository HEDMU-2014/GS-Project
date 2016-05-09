package beans;

import java.util.Optional;

import javax.ejb.Remote;

import domain.Interest;

@Remote
public interface InterestsBeanRemote {
    void create(Interest interest);
    Optional<Interest> read(int interestId);
    void update(Interest interest);
    void delete(Interest interest);
}
