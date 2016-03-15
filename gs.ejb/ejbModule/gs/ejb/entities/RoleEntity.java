package gs.ejb.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

@Entity(name = "Role")
@NamedQueries({
      @NamedQuery(name = RoleEntity.findAll, query = "SELECT r FROM Role r")
})
public class RoleEntity {
   public static final String findAll = "Role.findAll";

   @Id @GeneratedValue
   private int id;

   @NotNull
   private String name;

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }
}
