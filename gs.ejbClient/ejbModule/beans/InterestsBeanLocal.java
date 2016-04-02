package beans;

import domain.Interest;

import java.util.Optional;

@Local
public interface InterestsBeanLocal {
    void create(Interest interest);
    Optional<Interest> read(int interestId);
    void update(Interest interest);
    void delete(Interest interest);
}
