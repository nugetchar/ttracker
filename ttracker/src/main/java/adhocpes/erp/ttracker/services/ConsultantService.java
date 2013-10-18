package adhocpes.erp.ttracker.services;

import java.util.List;

import adhocpes.erp.ref.model.Consultant;
import adhocpes.erp.ref.model.Project;
import adhocpes.erp.ttracker.domain.Tache;


public interface ConsultantService {
	//Retrieving consultants
	public List<Consultant> getAllConsultants();
	public List<Consultant> getConsultantsForProject(Project p);
	public Consultant getConsultantForTache(Tache t);
	
	public Consultant getConsultant(String nom);
	
}
