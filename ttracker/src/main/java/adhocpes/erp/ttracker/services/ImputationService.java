package adhocpes.erp.ttracker.services;

import java.util.List;

import adhocpes.erp.ref.model.Consultant;
import adhocpes.erp.ttracker.domain.Imputation;
import adhocpes.erp.ttracker.domain.Tache;

public interface ImputationService {
	
	//Retrieving taches
	public List<Imputation> getAllImputations();
	public List<Imputation> getImputationsForConsultant(Consultant c);
	public List<Imputation> getImputationsForTache(Tache t);
	
	//TODO définir paramètres
	public Imputation getImputation();
}
