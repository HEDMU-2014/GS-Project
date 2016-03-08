package ejb.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Entity implementation class for Entity: Users
 *
 */
@Entity

public class Users implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userid;
	
	@Column(nullable=false, length=50)
	private String firstName;
	
	@Column(nullable=false, length=50)
	private String lastName;
	
	@Column(nullable=false, unique=true, length=50)
	private String email;
	
	@Column(nullable=false, length=128)
	private String password;
	
	@NotNull
	private LocalDateTime createdDate;
	
	private LocalDateTime lastLogin;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="AssignedRoles",
			joinColumns=@JoinColumn(name="userid", referencedColumnName="userid"),
			inverseJoinColumns=@JoinColumn(name="roleid", referencedColumnName="roleid"))
	private Collection<Roles> roles;
	
	//private Organizations organization;

	public Users() {
		super();
	}
   
}
