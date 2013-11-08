package adhocpes.erp.timetracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import adhocpes.erp.domain.Consultant;
import adhocpes.erp.domain.Projet;
import adhocpes.erp.timetracker.domain.Imputation;
import adhocpes.erp.timetracker.domain.Tache;
import adhocpes.erp.timetracker.repository.TacheRepository;

@Service
public class TacheServiceImpl implements TacheService {

	@Autowired
	private TacheRepository tacheRepository;

	
	public TacheServiceImpl(){
		
	}
	
	public void insertTache(Tache t) {
		// TODO Auto-generated method stub
		tacheRepository.save(t);
	}

	public void deleteTache(Tache t) {
		// TODO Auto-generated method stub
		tacheRepository.delete(t);
	}

	public void updateTache(Tache t) {
		// TODO Auto-generated method stub
		tacheRepository.save(t);
	}

	public List<Tache> getAll() {
		// TODO Auto-generated method stub
		return tacheRepository.findAll();
	}

	public Tache getOne(long id) {
		// TODO Auto-generated method stub
		return tacheRepository.findOne(id);
	}

	public List<Tache> getTachesByProject(Projet p) {
		// TODO Auto-generated method stub
		return tacheRepository.findByProjet(p);
	}

	public List<Tache> getTachesByConsultant(Consultant c) {
		// TODO Auto-generated method stub
		return tacheRepository.findByConsultant(c);
	}

	public Tache getByImputation(Imputation i) {
		// TODO Auto-generated method stub
		return tacheRepository.findByImputation(i);
	}
	


}
