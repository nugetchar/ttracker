package adhocpes.erp.timetracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
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
@Repository
@Transactional
public interface TacheRepository  extends JpaRepository<Tache,Long> {
	
	static final String findByConsultant = "SELECT t FROM T_Imputation i, T_Tache t, T_Projet p WHERE i.consultant = :consultant"
			+ " AND i.tache = t AND t.projet = p";
	
	static final String findByImputation = "SELECT t FROM T_Imputation i, T_Tache t WHERE i.tache = t AND i = :imputation";
	static final String findNonFinies = "SELECT t FROM T_Tache t WHERE t.fini = 0";
	static final String findByNomAndProjet = "SELECT t FROM T_Tache t WHERE t.nom = :nom AND t.projet = :projet";
	
	List<Tache> findAll();
	List<Tache> findByProjet(Projet projet);

	@Query(findNonFinies)
	List<Tache> findNonFinies();
	@Query(findByConsultant)
	List<Tache> findByConsultant(@Param("consultant")Consultant consultant);

	@Query(findByImputation)
	Tache findByImputation(@Param("imputation")Imputation imputation);
	
	@Query(findByNomAndProjet)
	Tache findByNomAndProjet(@Param("nom")String nom, @Param("projet")Projet p);

	
}
