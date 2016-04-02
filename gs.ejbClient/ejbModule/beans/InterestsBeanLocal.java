package beans;

import java.util.Optional;

import javax.ejb.Local;

import domain.Interest;

@Local
public interface InterestsBeanLocal {
    void create(Interest interest);
    Optional<Interest> read(int interestId);
    void update(Interest interest);
    void delete(Interest interest);
}
