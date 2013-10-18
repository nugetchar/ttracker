package adhocpes.erp.ttracker.services;

import java.util.List;

import org.springframework.stereotype.Service;

import adhocpes.erp.ref.model.Consultant;
import adhocpes.erp.ref.model.Project;
import adhocpes.erp.ttracker.domain.Tache;

@Service
public class TacheServiceImpl implements TacheService {

	@Override
	public List<Tache> getAllTaches() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tache> getTachesForProject(Project p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tache> getTachesForConsultant(Consultant c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tache getTache(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

}
