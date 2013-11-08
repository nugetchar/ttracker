package adhocpes.erp.timetracker.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import adhocpes.erp.domain.Consultant;
import adhocpes.erp.domain.Projet;
import adhocpes.erp.service.ConsultantService;
import adhocpes.erp.service.ProjetService;
import adhocpes.erp.timetracker.domain.Affectation;
import adhocpes.erp.timetracker.repository.AffectationRepository;
import adhocpes.erp.timetracker.services.AffectationService;

@Service
@Transactional
public class AffectationServiceImpl implements AffectationService {

	@Autowired
	private AffectationRepository affectationRepository;

	public Affectation insertOrEditAffectation(Affectation a, long projetId, long consultantId,
			ConsultantService cs, ProjetService ps) {
		
		Projet p = ps.getById(projetId);
		Consultant c = cs.getById(consultantId);
		
		a.setConsultant(c);
		a.setProjet(p);
		return affectationRepository.save(a);
	}

	public void deleteAffectation(long id) {
		affectationRepository.delete(id);
		affectationRepository.flush();
	}

	public Affectation getOne(long id) {
		return affectationRepository.findOne(id);
	}

	public List<Affectation> getAll() {
		return affectationRepository.findAll();
	}

	public List<Affectation> findByProjet(Projet projet) {
		return affectationRepository.findByProjetAffecte(projet);
	}

	public List<Affectation> findByConsultant(Consultant consultant) {
		return affectationRepository.findByConsultantAffecte(consultant);
	}

}
