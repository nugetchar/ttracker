package adhocpes.erp.timetracker.services;

import java.util.List;

import adhocpes.erp.domain.Consultant;
import adhocpes.erp.domain.Projet;
import adhocpes.erp.service.ConsultantService;
import adhocpes.erp.service.ProjetService;
import adhocpes.erp.timetracker.domain.Affectation;

public interface AffectationService {
	
	
	Affectation insertOrEditAffectation(Affectation a, long projetId, long consultantId, ConsultantService cs, ProjetService ps);
	void deleteAffectation(long id);
	
	Affectation getOne(long id);
	
	List<Affectation> getAll();

	List<Affectation> findByProjet(Projet projet);

	List<Affectation> findByConsultant(Consultant consultant);
}
