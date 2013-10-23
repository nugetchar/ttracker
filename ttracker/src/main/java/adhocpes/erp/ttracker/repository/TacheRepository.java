package adhocpes.erp.ttracker.repository;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import adhocpes.erp.ref.model.Consultant;
import adhocpes.erp.ref.model.Project;
import adhocpes.erp.ttracker.domain.Tache;

@Transactional
public interface TacheRepository {
	void insertTache(Tache t);
	void deleteTache(Tache t);
	void updateTache(Tache t);
	Tache findByTacheName(String name);
	List<Tache> findAll();
	List<Tache> findTachesByProject(Project p);
	List<Tache> findTachesByConsultant(Consultant c);
}
