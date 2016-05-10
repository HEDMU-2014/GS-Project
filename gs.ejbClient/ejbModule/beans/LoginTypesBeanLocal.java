package beans;

import java.util.List;
import java.util.Optional;

import javax.ejb.Local;

import domain.LoginType;

@Local
public interface LoginTypesBeanLocal {

	public void create(LoginType logintype);
	public Optional<LoginType> read(int logintypeId);
	public void update(LoginType logintype);
	public void delete(LoginType logintype);
	public List<LoginType> allLoginTypes();
}
