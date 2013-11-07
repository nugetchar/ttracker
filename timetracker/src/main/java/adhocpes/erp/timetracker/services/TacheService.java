package adhocpes.erp.timetracker.services;

import java.util.List;

import adhocpes.erp.domain.Consultant;
import adhocpes.erp.domain.Projet;
import adhocpes.erp.service.ProjetService;
import adhocpes.erp.timetracker.domain.Imputation;
import adhocpes.erp.timetracker.domain.Tache;


public interface TacheService {
	//inserting, deleting, updating
	Tache insertOrEditTache(Tache t, long projetId, ProjetService serviceProj);
	void deleteTache(long id);
	
	//retrieving
	List<Tache> getAll();
	Tache getOne(long id);
	List<Tache> getTachesByProject(Projet p);
	List<Tache> getTachesByConsultant(Consultant c);
	List<Tache> getNonFinies();
	
	Tache getByNomAndProjet(String nom, Projet p);
	Tache getByImputation(Imputation i);
}
