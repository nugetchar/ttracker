package adhocpes.erp.ref.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author qing
 *
 */
@Entity
public class Client {
	
	private Long clientId;
	private String clientName;

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(String clientName) {
		super();
		this.clientName = clientName;
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

}
