package adhocpes.erp.timetracker.repository;

import java.util.List;

import org.joda.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import adhocpes.erp.domain.Projet;
import adhocpes.erp.domain.Consultant;
import adhocpes.erp.timetracker.domain.Affectation;

/**
 * 
 * @author toledo
 *
 */
@Repository
@Transactional
public interface AffectationRepository  extends JpaRepository<Affectation,Long>{

	List<Affectation> findAll();

	Affectation findByProjet(Projet projet);

	Affectation findByConsultant(Consultant consultant);

}
