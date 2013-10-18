package adhocpes.erp.ttracker.services;

import java.util.List;

import org.springframework.stereotype.Service;

import adhocpes.erp.ref.model.Consultant;
import adhocpes.erp.ref.model.Project;
import adhocpes.erp.ttracker.domain.Tache;

@Service
public class ConsultantServiceImpl implements ConsultantService {

	@Override
	public List<Consultant> getAllConsultants() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Consultant> getConsultantsForProject(Project p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Consultant getConsultantForTache(Tache t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Consultant getConsultant(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

}
