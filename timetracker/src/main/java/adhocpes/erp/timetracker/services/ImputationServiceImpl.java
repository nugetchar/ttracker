package adhocpes.erp.timetracker.services;

import java.util.List;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import adhocpes.erp.domain.Consultant;
import adhocpes.erp.domain.Projet;
import adhocpes.erp.service.ConsultantService;
import adhocpes.erp.timetracker.domain.Imputation;
import adhocpes.erp.timetracker.domain.Tache;

import adhocpes.erp.timetracker.repository.ImputationRepository;

@Service
@Transactional
public class ImputationServiceImpl implements ImputationService {

	@Autowired
	private ImputationRepository imputationRepository;

	public ImputationServiceImpl() {
	}

	public void insertOrEditImputation(Imputation i, long consultantId,
			long tacheId, TacheService ts, ConsultantService cs) {
		// TODO Auto-generated method stub
		List<Imputation> imputations;
		Tache t = ts.getOne(tacheId);
		Consultant c = cs.getById(consultantId);
		
		i.setTache(t);
		i.setConsultant(c);
		
		imputations = i.getTache().getImputations();
		
		if (imputations.indexOf(i) == -1)
			i.getTache().getImputations().add(i);
		
		imputationRepository.save(i);
	}

	public void deleteImputation(long id) {
		// TODO Auto-generated method stub
		imputationRepository.delete(id);
		imputationRepository.flush();
	}

	public void insertOrEditImputations(List<Imputation> imputations,
			TacheService ts, ConsultantService cs) {
		for (Imputation i : imputations)
			insertOrEditImputation(i, i.getConsultant().getId(), i.getTache()
					.getId(), ts, cs);
	}

	public Imputation getOne(long id) {
		// TODO Auto-generated method stub
		return imputationRepository.findOne(id);
	}

	public List<Imputation> getAll() {
		// TODO Auto-generated method stub
		return imputationRepository.findAll();
	}

	public List<Imputation> getImputationsByProjet(Projet p) {
		// TODO Auto-generated method stub
		return imputationRepository.findByProjet(p);
	}

	public List<Imputation> getImputationsByConsultant(Consultant c) {
		// TODO Auto-generated method stub
		return imputationRepository.findByConsultant(c);
	}

	public List<Imputation> getImputationsByTache(Tache t) {
		// TODO Auto-generated method stub
		return imputationRepository.findByTache(t);
	}

	public List<Imputation> getByDateConsultant(LocalDate date, Consultant c) {
		// TODO Auto-generated method stub
		return imputationRepository.findByDateConsultant(date, c);
	}

	public List<Imputation> getByDateProjet(LocalDate date, Projet p) {
		// TODO Auto-generated method stub
		return imputationRepository.findByDateProjet(date, p);
	}

	public Imputation getByDateTache(LocalDate date, Tache t) {
		// TODO Auto-generated method stub
		return imputationRepository.findByDateTache(date, t);
	}

	public List<Imputation> getByMonthYearConsultant(int month, int year,
			Consultant c) {
		// TODO Auto-generated method stub
		return imputationRepository.findByMonthYearConsultant(month, year, c);
	}

	public Imputation getByTacheDateConsultant(Tache t, LocalDate d,
			Consultant c) {
		// TODO Auto-generated method stub
		return imputationRepository.findByTacheDateConsultant(t,d,c);
	}

}
