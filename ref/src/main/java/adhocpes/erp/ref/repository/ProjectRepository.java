package adhocpes.erp.ref.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import adhocpes.erp.ref.model.Project;

/**
 * @author qing
 *
 */
@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
	public Project findByProjectName(String projectName);

}
