package adhocpes.erp.ttracker.services;

import java.util.List;

import adhocpes.erp.ref.model.Consultant;
import adhocpes.erp.ref.model.Project;
import adhocpes.erp.ttracker.domain.Tache;

public interface TacheService {
	//Retrieving taches
	public List<Tache> getAllTaches();
	public List<Tache> getTachesForProject(Project p);
	public List<Tache> getTachesForConsultant(Consultant c);
	
	public Tache getTache(String nom);
}
