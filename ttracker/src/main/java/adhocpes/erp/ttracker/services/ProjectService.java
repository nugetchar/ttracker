package adhocpes.erp.ttracker.services;

import java.util.List;


import adhocpes.erp.ref.model.Consultant;
import adhocpes.erp.ref.model.Project;
import adhocpes.erp.ttracker.domain.Tache;


public interface ProjectService {
	//Retrieving taches
	public List<Tache> getAllProject();
	public List<Project> getProjectForTache(Tache t);
	public List<Tache> getProjectForConsultants(List<Consultant> c);
	
	public Project getProject(String nom);
}