package adhocpes.erp.ttracker.services;

import java.util.List;

import adhocpes.erp.ref.model.Consultant;
import adhocpes.erp.ref.model.Project;
import adhocpes.erp.ttracker.domain.Tache;

public interface TacheService {
	//Retrieving taches
	public List<Tache> findAll();
	public List<Tache> findTachesByProject(Project p);
	public List<Tache> findTacheByConsultant(Consultant c);
	public Tache findTacheByName(String nom);
	
	//Inserting, updating and deleting taches
	public void insertTache(Tache t);
	public void updateTache(Tache t);
	void deleteTache(Tache t);
}
