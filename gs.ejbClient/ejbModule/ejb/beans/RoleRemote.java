package ejb.beans;

import java.util.Optional;

import javax.ejb.Remote;

@Remote
public interface RoleRemote {
	
	String greeting(String key);
	
	void create(String key, String value);

	Optional<String> read(String key);

	void update(String key, String value);

	void delete(String key);

}
