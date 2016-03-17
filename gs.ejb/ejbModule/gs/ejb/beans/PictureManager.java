package gs.ejb.beans;

import gs.ejb.domain.Picture;
import gs.ejb.domain.Role;
import gs.ejb.entities.PictureEntity;
import gs.ejb.entities.RoleEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PictureManager implements PictureManagerLocal, PictureManagerRemote {
   @PersistenceContext
   EntityManager em;

   @Override
   public Picture findPicture(long id) {
      PictureEntity entity = findEntity(id);
      return (entity == null ? null : toDTO(entity));
   }

   @Override
   public void createPicture(Picture picture) {
      PictureEntity entity = new PictureEntity();
      map(picture, entity);
      em.persist(entity);
   }

   @Override
   public void updatePicture(Picture picture) {
      PictureEntity entity = findEntity(picture.getId());
      if (entity != null)
         map(picture, entity);
   }

   @Override
   public void deletePicture(Picture picture) {
      PictureEntity entity = findEntity(picture.getId());
      if (entity != null)
         em.remove(entity);
   }

   private PictureEntity findEntity(long id) {
      return em.find(PictureEntity.class, id);
   }

   private Picture toDTO(PictureEntity entity) {
      Picture dto = new Picture();
      dto.setId(entity.getId());
      dto.setImageUrl(entity.getImageUrl());
      dto.setCreationDate(entity.getCreationDate());
      return dto;
   }

   private void map(Picture dto, PictureEntity entity) {
      entity.setCreationDate(dto.getCreationDate());
   }
}
