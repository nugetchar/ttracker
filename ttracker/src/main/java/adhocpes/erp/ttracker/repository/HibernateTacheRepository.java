package adhocpes.erp.ttracker.repository;

import java.util.List;


import org.hibernate.Query;
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

	@Override
	public void deleteTache(Tache t) {
		// TODO Auto-generated method stub
		session.getCurrentSession().delete(t);	
	}

	@Override
	public void updateTache(Tache t) {
		// TODO Auto-generated method stub
		session.getCurrentSession().update(t);
	}

	@Override
	public Tache getTache(String name) {
		// TODO Auto-generated method stub
		return (Tache) session.getCurrentSession().get(Tache.class, name);
	}

	@Override
	public List<Tache> getAllTaches() {
		// TODO Générer erreur si cast raté
		Query query = session.getCurrentSession().createQuery("FROM Tache t");
		return (List<Tache>) query.list() ;
	}
}
