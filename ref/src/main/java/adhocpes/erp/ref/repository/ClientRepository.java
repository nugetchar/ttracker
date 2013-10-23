package adhocpes.erp.ref.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Repository;

import adhocpes.erp.ref.model.Client;

/**
 * @author qing
 *
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

	public Client findByClientId (Long clientId);
	public Client findByClientName (String clientName);
	public List<Client> findAll();
	
}
