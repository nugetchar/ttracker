package adhocpes.erp.ttracker.repository;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import adhocpes.erp.ref.model.Consultant;
import adhocpes.erp.ref.model.Project;
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
		session.getCurrentSession().delete(t);	
	}

	@Override
	public void updateTache(Tache t) {
		session.getCurrentSession().update(t);
	}

	@Override
	public Tache findByTacheName(String name) {
		return (Tache) session.getCurrentSession().get(Tache.class, name);
	}

	@Override
	public List<Tache> findAll() {
		// TODO Générer erreur si cast raté
		Query query = session.getCurrentSession().createQuery("FROM Tache t");
		return (List<Tache>) query.list() ;
	}

	@Override
	public List<Tache> findTachesByProject(Project p) {
		Query query = session.getCurrentSession().createQuery("FROM Tache t WHERE t.project = p");
		// TODO Générer erreur si cast raté
		return (List<Tache>) query.list();
	}

	@Override
	public List<Tache> findTachesByConsultant(Consultant c) {
		Query query = session.getCurrentSession().createQuery("FROM Tache t WHERE t.project = p");
		// TODO Générer erreur si cast raté
		return (List<Tache>) query.list();
	}
	
}
