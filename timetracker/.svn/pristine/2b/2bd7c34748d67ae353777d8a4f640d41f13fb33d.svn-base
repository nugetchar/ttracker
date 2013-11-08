package adhocpes.erp.timetracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import adhocpes.erp.timetracker.domain.Imputation;
import adhocpes.erp.timetracker.domain.Tache;
import adhocpes.erp.domain.Projet;
import adhocpes.erp.domain.Consultant;

/**
 * 
 * @author toledo
 *
 */
@Transactional
public interface TacheRepository  extends JpaRepository<Tache,Long> {
	
	static final String findByConsultant = "SELECT t FROM T_Imputation i, T_Tache t, T_Projet p WHERE i.consultant = :consultant"
			+ " AND i.tache = t AND t.projet = p";
	
	static final String findByImputation = "SELECT t FROM T_Imputation i, T_Tache t WHERE i.tache = t AND i = :imputation";
	List<Tache> findAll();
	List<Tache> findByProjet(Projet projet);

	@Query(findByConsultant)
	List<Tache> findByConsultant(@Param("consultant")Consultant consultant);

	@Query(findByImputation)
	Tache findByImputation(@Param("imputation")Imputation imputation);

}
