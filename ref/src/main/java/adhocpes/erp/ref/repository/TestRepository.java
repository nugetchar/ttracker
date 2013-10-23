package adhocpes.erp.ref.repository;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import adhocpes.erp.ref.model.Client;

public class TestRepository {
	public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext-ref.xml");

        ClientRepository repository = context.getBean(ClientRepository.class);

        repository.save(new Client("CA"));
        repository.save(new Client("HP"));
        repository.save(new Client("Micro"));
        
        // fetch all clients
        List<Client> clients = repository.findAll();
        System.out.println("Clients found with findAll():");
        System.out.println("-------------------------------");
        for (Client client : clients) {
            System.out.println(client.getClientName());
        }
        System.out.println();

        // fetch an individual client by ID
        Client client = repository.findByClientId(1L);
        System.out.println("Client found with findOne(1L):");
        System.out.println("--------------------------------");
        System.out.println(client.getClientName());
        System.out.println();

    }
}
