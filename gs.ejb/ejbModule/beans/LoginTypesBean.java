package beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.LoginType;
import entities.LoginTypes;

@Stateless
@LocalBean
public class LoginTypesBean implements LoginTypesBeanLocal {
	
	@PersistenceContext EntityManager em;

	@Override
    public void create(LoginType logintype) {
		LoginTypes entity = new LoginTypes(logintype);
		em.persist(entity);
    }
    
	@Override
    public Optional<LoginType> read(int logintypeId) {
		LoginTypes logintype = em.find(LoginTypes.class, logintypeId); 
		if (logintype != null) {
			return Optional.of(logintype.map(new LoginType()));
		} else {
			return Optional.empty();
		}
    }
    
	@Override
    public void update(LoginType logintype) {
		LoginTypes logintypes = em.find(LoginTypes.class, logintype.getId()); 
		if (logintypes != null) {
			logintypes.update(logintype);
		} else {
			throw new RuntimeException("Logintype with id " + logintype.getId() + " not found");
		}
    }
    
	@Override
    public void delete(LoginType logintype) {
		LoginTypes logintypes = em.find(LoginTypes.class, logintype.getId()); 
		if (logintypes != null) {
			em.remove(logintypes);
		} else {
			throw new RuntimeException("Logintype with id " + logintype.getId() + " not found");
		}
    }
	
	@Override
	public List<LoginType> allLoginTypes() {
		List<LoginType> logintypes = new ArrayList<>();
		List<LoginTypes> logintypee = em.createNamedQuery("allLoginTypes", LoginTypes.class)
				.getResultList();
		for (LoginTypes r : logintypee) {
			logintypes.add(r.map(new LoginType()));
		}
		return logintypes;
	}
}
