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
	List<Tache> getAllWithImputations();
	Tache getOne(long id);
	Tache getOneWithImputations(long id);
	List<Tache> getTachesByProject(Projet p);
	List<Tache> getTachesByConsultant(Consultant c);
	List<Tache> getNonFinies();
	
	Tache getByNomAndProjet(String nom, Projet p);
	Tache getByImputation(Imputation i);
	
	List<Tache> getTachesByProjectWithImputations(Projet p);
	List<Tache> getTachesByConsultantWithImputations(Consultant c);
	List<Tache> getNonFiniesWithImputations();
	
	Tache getByNomAndProjetWithImputations(String nom, Projet p);
	Tache getByImputationWithImputations(Imputation i);
	
	long getId(String nomTache, Projet p);
}
