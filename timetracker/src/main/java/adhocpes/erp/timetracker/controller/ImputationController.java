package adhocpes.erp.timetracker.controller;

import org.springframework.beans.factory.annotation.Autowired;

import adhocpes.erp.domain.Consultant;

import flexjson.JSONSerializer;
import flexjson.JSONDeserializer;

import java.util.HashMap;
import java.util.List;

import adhocpes.erp.service.ConsultantService;
import adhocpes.erp.service.ProjetService;
import adhocpes.erp.timetracker.services.ImputationService;
import adhocpes.erp.timetracker.services.TacheService;
import adhocpes.erp.timetracker.domain.Imputation;
import adhocpes.erp.timetracker.domain.Tache;
import adhocpes.erp.domain.Projet;

import org.apache.log4j.Logger;
import org.joda.time.LocalDate;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping("/imputations")
public class ImputationController {

	protected static Logger logger = Logger.getLogger("controller");

	@Autowired
	private Consultant current;

	@Autowired
	private ImputationService imputationService;

	@Autowired 
	private ConsultantService consultantService;

	@Autowired
	private TacheService tacheService;

	@Autowired
	private ProjetService projetService;

	public ImputationController(){

	}

	@RequestMapping("/timesheet/{month}/{year}")
	@ResponseBody
	public String getTimeSheet(@PathVariable("month") int month, @PathVariable("year") int year){
		System.out.println(current.getId());
		List<Imputation> imputations = imputationService.getByMonthYearConsultant(month, year, current);
		return Imputation.stringifyImputationList(imputations, month, year);
	}

	@RequestMapping(value="/timesheet/add", method=RequestMethod.POST, headers ={"Accept=application/json"})
	@ResponseBody
	public String addImputationTS(@RequestBody String s){
		HashMap<String,String> r = (HashMap<String,String>) (new JSONDeserializer()).deserialize(s);
		Tache t = tacheService.getOne(new Long(r.get("tacheId")));

		imputationService.insertOrEditImputations(Imputation.createImputationsFromMapTacheConsultant(current, t, r),
				tacheService, consultantService);
		return "{\"success\" : \"true\"}";
	}

	@RequestMapping(value="/timesheet/edit", method=RequestMethod.PUT, headers ={"Accept=application/json"})
	@ResponseBody
	public String editImputationTS(@RequestBody String s){
		HashMap<String,String> r = (HashMap<String,String>) (new JSONDeserializer()).deserialize(s);

		//Changement du projet, de la tâche ou des charges des imputations


		//Si on change juste UNE imputation
		try{
			new Integer(r.get("nom_cellule"));

		}catch(Exception e){
			//sinon on change le projet ou la tâche
			
			return "{\"success\" : \"true\"}";
		}

		//Si on a changé l'imputation
		//Et qu'on a mis 0
		//Soit on supprime l'imputation, soit on met 0 pour une imputation qui n'existe pas encore

		Projet p = projetService.getByNom(r.get("nom"));
		Tache t = tacheService.getByNomAndProjet(r.get("tache"), p);
		LocalDate d = new LocalDate(new Integer(r.get("year")),new Integer(r.get("month")),
				new Integer(r.get("nom_cellule")));

		//On récupère l'imputation
		Imputation i = imputationService.getByTacheDateConsultant(t, d, current);
		
		//Existe-t-elle?
		if(i != null){
			i.setCharge(new Double(r.get("valeur")));
			//Doit-elle être supprimée?
			if(i.getCharge() == 0)
				imputationService.deleteImputation(i.getId());
			else
				imputationService.insertOrEditImputation(i, current.getId(), t.getId(), tacheService, consultantService);
		}

		return "{\"success\" : \"true\"}";
	}
}
