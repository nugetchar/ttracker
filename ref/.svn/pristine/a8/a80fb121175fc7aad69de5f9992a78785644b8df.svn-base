package adhocpes.erp.ref.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import adhocpes.erp.ref.model.Consultant;

/**
 * @author qing
 *
 */
@Repository
public interface ConsultantRepository extends JpaRepository<Consultant, Long> {
	public Consultant findByConsultantName(String consultantName);
}
