package gs.ejb.domain;

import java.io.Serializable;

public class Picture implements Serializable {
   private long id;

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }
}
