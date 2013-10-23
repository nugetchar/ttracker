package adhocpes.erp.ttracker.services;

import java.util.List;

import adhocpes.erp.ref.model.Project;
import adhocpes.erp.ttracker.domain.Tache;


public interface ProjectService {
	
	public List<Project> getAllProject();
	public Project getProjectForTache(Tache t);
	public Project getProject(String nom);
}