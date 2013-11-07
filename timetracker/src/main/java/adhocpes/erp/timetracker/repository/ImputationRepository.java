package adhocpes.erp.timetracker.repository;

import java.util.List;

import org.joda.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import adhocpes.erp.timetracker.domain.Tache;
import adhocpes.erp.timetracker.domain.Imputation;
import adhocpes.erp.domain.Projet;
import adhocpes.erp.domain.Consultant;

/**
 * 
 * @author toledo
 *
 */
@Repository
@Transactional
public interface ImputationRepository  extends JpaRepository<Imputation,Long>{

	static final String findByProjet = "SELECT i FROM T_Imputation i, T_Tache t WHERE i.tache.nom = t.nom AND t.projet = :projet";
	static final String findByDateConsultant = "SELECT i FROM T_Imputation i WHERE i.consultant = :consultant AND i.jour = :date";
	static final String findByDateProjet = "SELECT i FROM T_Imputation i, T_Tache t WHERE i.tache.projet = :projet AND i.jour = :date";
	static final String findByDateTache = "SELECT i FROM T_Imputation i WHERE i.tache = :tache AND i.jour = :date";
	static final String findByMonthYearConsultant = "SELECT i FROM T_Imputation i WHERE i.consultant = :consultant" +
			" AND i.month = :m AND i.year = :y";
	static final String findByTacheDateConsultant = "SELECT i FROM T_Imputation i WHERE" +
			" i.tache = :tache AND i.jour = :jour AND i.consultant = :consultant";
	
	List<Imputation> findAll();

	@Query(findByProjet)
	List<Imputation> findByProjet(@Param("projet")Projet projet);
	List<Imputation> findByConsultant(Consultant consultant);
	List<Imputation> findByTache(Tache tache);
	@Query(findByDateConsultant)
	List<Imputation> findByDateConsultant(@Param("date")LocalDate date, @Param("consultant")Consultant consultant);
	@Query(findByDateProjet)
	List<Imputation> findByDateProjet(@Param("date")LocalDate date, @Param("projet")Projet projet);
	
	@Query(findByDateTache)
	Imputation findByDateTache(@Param("date")LocalDate date, @Param("tache")Tache tache);
	
	@Query(findByMonthYearConsultant)
	List<Imputation> findByMonthYearConsultant(@Param("m")int m, @Param("y")int y, @Param("consultant")Consultant c);

	@Query(findByTacheDateConsultant)
	Imputation findByTacheDateConsultant(@Param("tache")Tache t, @Param("jour")LocalDate d, @Param("consultant")Consultant c);
}
