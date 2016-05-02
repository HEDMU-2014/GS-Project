package beans;

import domain.HasId;
import beans.mapping.DomainMapper;

import javax.ejb.EJBException;
import javax.ejb.ObjectNotFoundException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class ManagerBean<T extends HasId<K>, E extends HasId<K>, K extends Serializable> {
   private final Class<T> domainClass;
   private final Class<E> entityClass;

   private final DomainMapper<T, E> mapper;

   @PersistenceContext
   private EntityManager em;

   protected ManagerBean(Class<T> domainClass, Class<E> entityClass) {
      this.domainClass = domainClass;
      this.entityClass = entityClass;

      mapper = new DomainMapper<>(domainClass, entityClass);
   }

   // Allow injecting a mock EntityManager for testing
   void setEntityManager(EntityManager em) {
      this.em = em;
   }

   public T find(K id) throws ObjectNotFoundException {
      return toDomain(findEntity(id));
   }

   public T create(T domainObj) {
      E entity = toEntity(domainObj);
      em.persist(entity);
      return toDomain(entity);
   }

   public void update(T domainObj) throws ObjectNotFoundException {
      mapper.mapToEntity(domainObj, findEntity(domainObj.getId()));
   }

   public void delete(T domainObj) throws ObjectNotFoundException {
      em.remove(findEntity(domainObj.getId()));
   }

   public E toEntity(T domainObj) {
      return mapper.mapToEntity(domainObj, newInstance(entityClass));
   }

   public T toDomain(E entity) {
      return mapper.mapToDomain(entity, newInstance(domainClass));
   }

   public List<T> toDomain(Collection<E> entities) {
      List<T> result = new ArrayList<>();

      if (entities != null) {
         entities.forEach(entity ->
               result.add(toDomain(entity)));
      }

      return result;
   }

   protected List<T> query(String queryName) {
      return query(createQuery(queryName));
   }

   protected List<T> query(TypedQuery<E> query) {
      List<T> result = new ArrayList<>();

      query.getResultList().forEach(entity ->
            result.add(toDomain(entity)));

      return result;
   }

   protected TypedQuery<E> createQuery(String queryName) {
      return em.createNamedQuery(queryName, entityClass);
   }

   private E findEntity(K id) throws ObjectNotFoundException {
      E entity = em.find(entityClass, id);

      if (entity == null)
         throw new ObjectNotFoundException();

      return entity;
   }

   private static <R> R newInstance(Class<R> clazz) {
      try {
         return clazz.newInstance();
      } catch (InstantiationException | IllegalAccessException e) {
         throw new EJBException(e);
      }
   }
}
