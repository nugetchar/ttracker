package adhocpes.erp.ttracker.repository;

import org.springframework.transaction.annotation.Transactional;

import adhocpes.erp.ttracker.domain.Tache;

@Transactional
public interface TacheRepository {
	@Transactional
	void insertTache(Tache t);
}
