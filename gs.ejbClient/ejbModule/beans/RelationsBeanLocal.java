package beans;

import java.util.Optional;

import javax.ejb.Local;

import domain.Relation;
import domain.UserRelationPK;

@Local
public interface RelationsBeanLocal {

	Optional<Relation> readRelation(UserRelationPK key);

	void createRelation(Relation key);

	void updateRelation(Relation key);

	void deleteRelation(Relation key);

}
