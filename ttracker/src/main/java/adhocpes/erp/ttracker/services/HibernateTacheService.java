package adhocpes.erp.ttracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import adhocpes.erp.ref.model.Consultant;
import adhocpes.erp.ref.model.Project;
import adhocpes.erp.ttracker.domain.Tache;
import adhocpes.erp.ttracker.repository.TacheRepository;

public class HibernateTacheService implements TacheService {

	@Autowired
	private TacheRepository tacheRepository;

	public HibernateTacheService(){
		
	}
	
	@Override
	public List<Tache> findAll() {
		return tacheRepository.findAll();
	}

	@Override
	public List<Tache> findTachesByProject(Project p) {
		return tacheRepository.findTachesByProject(p);
	}

	@Override
	public List<Tache> findTacheByConsultant(Consultant c) {
		return tacheRepository.findTachesByConsultant(c);
	}

	@Override
	public Tache findTacheByName(String nom) {
		return tacheRepository.findByTacheName(nom);
	}

	@Override
	public void insertTache(Tache t) {
		tacheRepository.insertTache(t);
	}

	@Override
	public void updateTache(Tache t) {
		tacheRepository.updateTache(t);
	}

	@Override
	public void deleteTache(Tache t){
		tacheRepository.deleteTache(t);
	}

}
