package adhocpes.erp.timetracker.controller;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import flexjson.JSONDeserializer;

import adhocpes.erp.service.ConsultantService;
import adhocpes.erp.service.ProjetService;
import adhocpes.erp.timetracker.domain.Affectation;
import adhocpes.erp.timetracker.domain.Tache;
import adhocpes.erp.timetracker.services.AffectationService;

@Controller
@RequestMapping("/affectations")
public class AffectationController {
	protected static Logger logger = Logger.getLogger("controller");

	@Autowired
	private AffectationService affectationService;

	@Autowired
	private ConsultantService consultantService;

	@Autowired
	private ProjetService projetService;

	public AffectationController() {
	}

	@RequestMapping("")
	public String listAll() {
		return "affectation";
	}

	@RequestMapping("/manage")
	@ResponseBody
	public String retrieveTaches() {
		String res = "{\"total\":\"10\",\"page\":\"1\",\"records\":\"3\",\"rows\":"
				+ Affectation.stringifyList(affectationService.getAll());
		res += "}";
		return res;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, headers = { "Accept=application/json" })
	@ResponseBody
	public String addTache(@RequestBody String s) {
		HashMap<String, String> r = (HashMap<String, String>) (new JSONDeserializer())
				.deserialize(s);
		Affectation a = new Affectation();
		a = affectationService.insertOrEditAffectation(a,
				new Long(r.get("projet")), new Long(r.get("consultant")),
				consultantService, projetService);

		return "{\"success\" : \"true\", \"newId\" : \"" + a.getId() + "\"}";

	}

	@RequestMapping(value = "/edit", method = RequestMethod.PUT, headers = { "Accept=application/json" })
	@ResponseBody
	public String editTache(@RequestBody String s) {
		HashMap<String, String> r = (HashMap<String, String>) (new JSONDeserializer())
				.deserialize(s);

		Affectation a = new Affectation();
		a.setId(new Long(r.get("id")));
		affectationService.insertOrEditAffectation(a,
				new Long(r.get("projet")), new Long(r.get("consultant")),
				consultantService, projetService);
		return "{\"success\" : \"true\"}";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE, headers = { "Accept=application/json" })
	@ResponseBody
	public String deleteTache(@RequestBody String s) {
		HashMap<String, String> r = (HashMap<String, String>) (new JSONDeserializer())
				.deserialize(s);
		affectationService.deleteAffectation(new Long(r.get("id")));
		return "{\"success\" : \"true\"}";
	}
}
