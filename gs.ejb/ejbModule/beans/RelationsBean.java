package beans;

import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.Relation;
import domain.UserRelationPK;
import entities.Relations;

/**
 * Session Bean implementation class RelationsBean
 */
@Stateless
public class RelationsBean implements RelationsBeanLocal {
	@PersistenceContext private EntityManager em;

	@Override
	public Optional<Relation> readRelation(UserRelationPK key) {
		Optional<Relation> opt = Optional.empty();
		Relations intCon = em.find(Relations.class, key); 
		if (intCon != null) {
			opt = Optional.of(intCon.map(new Relation()));
		}
		return opt;
	}
	
	@Override
	public void createRelation(Relation key) {
		Relations entity = new Relations(key);
		em.persist(entity);
	}
	
	@Override
	public void updateRelation(Relation key) {
		Relations entity = em.find(Relations.class, key); 
		if (entity != null) {
			entity.update(key);
		} else {
			throw new RuntimeException("Relation with id " + key + " not found");
		}
	}
	
	@Override
	public void deleteRelation(Relation key) {
		Relations entity = em.find(Relations.class, key); 
		if (entity != null) {
			em.remove(entity);
		} else {
			throw new RuntimeException("Relation with id " + key + " not found");
		}
	}



}
