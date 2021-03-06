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

	public ImputationController() {

	}

	@RequestMapping("/timesheet/{month}/{year}")
	@ResponseBody
	public String getTimeSheet(@PathVariable("month") int month,
			@PathVariable("year") int year) {
		String res = "{\"total\":\"10\",\"page\":\"1\",\"records\":\"3\",\"rows\":[";
		List<Tache> tachesAffectees = tacheService
				.getTachesByConsultantWithImputations(current);
		List<Imputation> imputations;
		LocalDate date;
		int i, j, k;
		for (i = 0; i < tachesAffectees.size(); ++i) {
			res += "{\"projet\":\""
					+ tachesAffectees.get(i).getprojet().getNom() + "\",";
			res += "\"tache\":\"" + tachesAffectees.get(i).getNom() + "\",";
			imputations = tachesAffectees.get(i).getImputations();
			for (j = 1; j < 32; ++j) {
				for (k = 0; k < imputations.size()
						&& !((date = imputations.get(k).getJour())
								.getMonthOfYear() == month
								&& date.getDayOfMonth() == j && date.getYear() == year); ++k);

				if (k == imputations.size())
					res += "\"" + j + "\":\"0\"";
				else
					res += "\"" + j + "\":\"" + imputations.get(k).getCharge()
							+ "\"";

				if (j < 31)
					res += ",";

			}
			res += "}";
			if (i < tachesAffectees.size() - 1)
				res += ",";
		}
		res += "]}";
		return res;
	}

	@RequestMapping(value = "/timesheet/edit", method = RequestMethod.PUT, headers = { "Accept=application/json" })
	@ResponseBody
	public String editImputationTS(@RequestBody String s) {
		HashMap<String, String> r = (HashMap<String, String>) (new JSONDeserializer())
				.deserialize(s);

		// Si on a changé l'imputation
		// Et qu'on a mis 0
		// Soit on supprime l'imputation, soit on met 0 pour une imputation qui
		// n'existe pas encore

		Projet p = projetService.getByNom(r.get("projet"));
		long tacheId = tacheService.getId(r.get("tache"), p);
		LocalDate d = new LocalDate(new Integer(r.get("year")), new Integer(
				r.get("month")), new Integer(r.get("nom_cellule")));

		// On récupère l'imputation
		Imputation i = new Imputation();
		i.setCharge(new Double(r.get("valeur")));
		i.setJour(d);

		// Doit-elle être supprimée?
		if (i.getCharge() == 0) {
			i.setConsultant(current);
			i.setTache(tacheService.getOne(tacheId));
			imputationService.deleteImputation(i);
		}
		// sinon on l'insère ou on l'update
		else {
			imputationService.insertOrEditImputation(i, current.getId(),
					tacheId, tacheService, consultantService);
		}

		return "{\"success\" : \"true\"}";
	}
}
