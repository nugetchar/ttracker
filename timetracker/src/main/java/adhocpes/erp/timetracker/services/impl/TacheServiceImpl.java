package adhocpes.erp.timetracker.services.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import adhocpes.erp.domain.Consultant;
import adhocpes.erp.domain.Projet;
import adhocpes.erp.service.ProjetService;
import adhocpes.erp.timetracker.domain.Imputation;
import adhocpes.erp.timetracker.domain.Tache;
import adhocpes.erp.timetracker.repository.TacheRepository;
import adhocpes.erp.timetracker.services.TacheService;

@Service
@Transactional
public class TacheServiceImpl implements TacheService {

	@Autowired
	private TacheRepository tacheRepository;

	
	public TacheServiceImpl(){
		
	}
	
	public Tache insertOrEditTache(Tache t, long projetId, ProjetService serviceProj) {
		// TODO Auto-generated method stub
		Projet p = serviceProj.getById(projetId);
		t.setprojet(p);
		return tacheRepository.save(t);
	}

	public void deleteTache(long id) {
		// TODO Auto-generated method stub
		tacheRepository.delete(id);
	}


	public List<Tache> getAll() {
		// TODO Auto-generated method stub
		return tacheRepository.findAll();
	}

	public List<Tache> getAllWithImputations(){
		List<Tache> taches = getAll();
		for(Tache t : taches)
			Hibernate.initialize(t.getImputations());
		return taches;
	}

	
	public Tache getOne(long id) {
		// TODO Auto-generated method stub
		return tacheRepository.findOne(id);
	}
	
	public Tache getOneWithImputations(long id){
		Tache t = tacheRepository.findOne(id);
		
		Hibernate.initialize(t.getImputations());
		return t;
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
	
	public List<Tache> getNonFinies(){
		return tacheRepository.findNonFinies();
	}

	public Tache getByNomAndProjet(String nom, Projet p) {
		// TODO Auto-generated method stub
		return tacheRepository.findByNomAndProjet(nom,p);
	}

	public long getId(String nomTache, Projet p) {
		// TODO Auto-generated method stub
		return tacheRepository.findId(nomTache, p);
	}

	public List<Tache> getTachesByProjectWithImputations(Projet p) {
		List<Tache> taches = getTachesByProject(p);
		for(Tache t : taches)
			Hibernate.initialize(t.getImputations());
		return taches;
	}

	public List<Tache> getTachesByConsultantWithImputations(Consultant c) {
		List<Tache> taches = getTachesByConsultant(c);
		for(Tache t : taches)
			Hibernate.initialize(t.getImputations());
		return taches;
	}

	public List<Tache> getNonFiniesWithImputations() {
		List<Tache> taches = getNonFinies();
		for(Tache t : taches)
			Hibernate.initialize(t.getImputations());
		return taches;
	}

	public Tache getByNomAndProjetWithImputations(String nom, Projet p) {
		Tache t = tacheRepository.findByNomAndProjet(nom, p);
		Hibernate.initialize(t.getImputations());
		return t;
	}

	public Tache getByImputationWithImputations(Imputation i) {
		Tache t = tacheRepository.findByImputation(i);
		Hibernate.initialize(t.getImputations());
		return t;
	}


}
