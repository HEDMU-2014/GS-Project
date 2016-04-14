package gs.ejb.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity(name = "Picture")
public class PictureEntity {
   @Id @GeneratedValue
   private long id;

   @ManyToOne
   private UserEntity user;

   private String imageUrl;

   @Temporal(TemporalType.TIMESTAMP)
   private Date creationDate;

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public UserEntity getUser() {
      return user;
   }

   public void setUser(UserEntity user) {
      this.user = user;
   }

   public String getImageUrl() {
      return imageUrl;
   }

   public void setImageUrl(String imageUrl) {
      this.imageUrl = imageUrl;
   }

   public Date getCreationDate() {
      return creationDate;
   }

   public void setCreationDate(Date creationDate) {
      this.creationDate = creationDate;
   }
}
