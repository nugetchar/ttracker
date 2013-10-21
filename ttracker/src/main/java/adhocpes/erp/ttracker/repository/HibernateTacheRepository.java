package adhocpes.erp.ttracker.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import adhocpes.erp.ttracker.domain.Tache;
public class HibernateTacheRepository implements TacheRepository {
	
	@Autowired
	SessionFactory session;
	
	public HibernateTacheRepository(){
	}
	
	@Override
	public void insertTache(Tache t){
		session.getCurrentSession().save(t);
	}
}
