package adhocpes.erp.timetracker.services;

import java.util.List;

import adhocpes.erp.domain.Consultant;
import adhocpes.erp.domain.Projet;
import adhocpes.erp.service.ProjetService;
import adhocpes.erp.timetracker.domain.Imputation;
import adhocpes.erp.timetracker.domain.Tache;


public interface TacheService {
	//inserting, deleting, updating
	Tache insertTache(Tache t, long projetId, ProjetService serviceProj);
	void deleteTache(long id);
	void updateTache(Tache t, long projetId, ProjetService serviceProj);
	
	//retrieving
	List<Tache> getAll();
	Tache getOne(long id);
	List<Tache> getTachesByProject(Projet p);
	List<Tache> getTachesByConsultant(Consultant c);
	Tache getByImputation(Imputation i);
}
