package adhocpes.erp.ttracker.services;

import java.util.List;

import org.springframework.stereotype.Service;

import adhocpes.erp.ref.model.Consultant;
import adhocpes.erp.ref.model.Project;
import adhocpes.erp.ttracker.domain.Tache;

@Service
public class ProjectServiceImpl implements ProjectService {

	
	@Override
	public List<Tache> getAllProject() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Project> getProjectForTache(Tache t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tache> getProjectForConsultants(List<Consultant> c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Project getProject(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

}
