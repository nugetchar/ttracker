package adhocpes.erp.utils;

import java.util.List;

import adhocpes.erp.domain.Client;
import adhocpes.erp.domain.Consultant;
import adhocpes.erp.domain.Projet;

public class Stringifier {
	public static String stringifyProjetList(List<Projet> projets){
		String res="[" + stringifyProjet(projets.get(0));
		for(int i=1; i<projets.size(); ++i)
			res += "," + stringifyProjet(projets.get(i));
		res += "]";
		return res;
	}

	public static String stringifyConsultantList(List<Consultant> consultants){
		String res="[" + stringifyConsultant(consultants.get(0));
		for(int i=1; i<consultants.size(); ++i)
			res += "," + stringifyConsultant(consultants.get(i));
		res += "]";
		return res;
	}

	public static String stringifyClientList(List<Client> client){
		String res="[" + stringifyClient(client.get(0));
		for(int i=1; i<client.size(); ++i)
			res += "," + stringifyClient(client.get(i));
		res += "]";
		return res;
	}

	private static String stringifyProjet(Projet projet){
		return "{\"id\":\""+projet.getId()+"\",\"projet\":\""+projet.getNom()+"\",\"client\":\""+projet.getClient().getNom()+
				"\",\"responsable\":\""+projet.getConsultantResponsable().getNom()+" "+
				projet.getConsultantResponsable().getPrenom()
				+"\"}";
	}

	private static String stringifyConsultant(Consultant consultant){
		String res =  "{\"id\":\""+consultant.getId()+"\",\"nom\":\""+consultant.getNom()+"\",\"prenom\":\""+consultant.getPrenom()+
				"\",\"email\":\""+consultant.getEmail()+"\",\"password\":\""+consultant.getPassword()
				+"\",\"manager\":\"";
		if(consultant.isManager())
			res += "oui";
		else
			res += "non";
		res += "\"}";
		return res;
	}
	
	private static String stringifyClient(Client client){
		return "{\"id\":\""+client.getId()+"\",\"client\":\""+client.getNom()+"\",\"description\":\""+client.getDescription()+
				"\",\"adresse\":\""+client.getAdresse()+"\",\"secteur\":\""+
				client.getSecteur()
				+"\"}";
	}
}
