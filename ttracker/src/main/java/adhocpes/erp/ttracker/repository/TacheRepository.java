package adhocpes.erp.ttracker.repository;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import adhocpes.erp.ttracker.domain.Tache;

@Transactional
public interface TacheRepository {
	void insertTache(Tache t);
	void deleteTache(Tache t);
	void updateTache(Tache t);
	Tache getTache(String name);
	List<Tache> getAllTaches();
}
