package beans.mapping;

import domain.HasId;

import javax.ejb.EJBException;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.lang.reflect.Field;

public class DomainMapper<T, E> {
   private final Class<T> domainClass;
   private final Class<E> entityClass;

   public DomainMapper(Class<T> domainClass, Class<E> entityClass) {
      this.domainClass = domainClass;
      this.entityClass = entityClass;
   }

   public T mapToDomain(E entity, T domainObj) {
      try {
         for (Field srcField : entityClass.getDeclaredFields()) {
            boolean useId = isRelation(srcField);

            for (Field targetField : domainClass.getDeclaredFields()) {
               if (useId) {
                  srcField.setAccessible(true);
                  Object value = srcField.get(entity);
                  if (value != null && targetField.getName().equals(srcField.getName() + "Id")) {
                     set(targetField, domainObj, ((HasId)value).getId());
                     break;
                  }
               } else if (targetField.getName().equals(srcField.getName())) {
                  map(srcField, entity, targetField, domainObj);
                  break;
               }
            }
         }

         return domainObj;
      } catch (Exception e) {
         throw new EJBException(e);
      }
   }

   public E mapToEntity(T domainObj, E entity) {
      try {
         for (Field targetField : entityClass.getDeclaredFields()) {
            // Skip field if relation or id
            if (isRelation(targetField) || isId(targetField)) {
               continue;
            }

            for (Field srcField : domainClass.getDeclaredFields()) {
               if (srcField.getName().equals(targetField.getName())) {
                  map(srcField, domainObj, targetField, entity);
                  break;
               }
            }
         }

         return entity;
      } catch (Exception e) {
         throw new EJBException(e);
      }
   }

   private static boolean isId(Field f) {
      return f.isAnnotationPresent(Id.class);
   }

   private static boolean isRelation(Field f) {
      return (f.isAnnotationPresent(OneToOne.class)
            || f.isAnnotationPresent(OneToMany.class)
            || f.isAnnotationPresent(ManyToOne.class)
            || f.isAnnotationPresent(ManyToMany.class));
   }

   private static void map(Field srcField, Object src, Field targetField, Object target)
         throws IllegalAccessException {
      srcField.setAccessible(true);
      set(targetField, target, srcField.get(src));
   }

   private static void set(Field field, Object target, Object value)
         throws IllegalAccessException {
      field.setAccessible(true);
      field.set(target, value);
   }
}
