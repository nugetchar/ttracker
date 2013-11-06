package adhocpes.erp.timetracker.controller;


import flexjson.JSONSerializer;
import flexjson.JSONDeserializer;

import java.util.HashMap;

import adhocpes.erp.service.ProjetService;
import adhocpes.erp.timetracker.services.TacheService;
import adhocpes.erp.timetracker.domain.Tache;
import adhocpes.erp.domain.Projet;

import org.apache.log4j.Logger;
import org.joda.time.LocalDate;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping("/taches")
public class TacheController {

	protected static Logger logger = Logger.getLogger("controller");

	@Autowired
	private TacheService tacheService;

	@Autowired
	private ProjetService projetService;

	public TacheController(){}

	/**
	 * @Brief liste toutes les tâches existantes. On se base ici
	 * sur le plug-in jqgrid, lequel permettra la suppression, modification, ajout de tâches
	 */
	@RequestMapping("")

	public String listAll(){
		return "tache";
	}

	/**
	 * @Brief fournit à jqgrid la liste des tâches en JSON
	 */
	@RequestMapping("/manage")
	@ResponseBody
	public String retrieveTaches(){
		String res = "{\"total\":\"10\",\"page\":\"1\",\"records\":\"3\",\"rows\":" + 
				Tache.stringifyList(tacheService.getAll());
		res += "}";
		return res;
	}

	/**
	 * @Brief ajout d'une tache
	 */
	@RequestMapping(value="/add", method=RequestMethod.PUT, headers ={"Accept=application/json"})
	@ResponseBody
	public String addTache(@RequestBody String s){
		HashMap<String,String> r = (HashMap<String,String>) (new JSONDeserializer()).deserialize(s);

		LocalDate d = new LocalDate(new Integer(r.get("year")),new Integer(r.get("month")),
				new Integer(r.get("day")));

		Tache t = new Tache(r.get("tache"),false,d);

		t = tacheService.insertTache(t,new Long(r.get("projetId")), projetService);
		return "{\"success\" : \"true\", \"newId\" : \""+t.getId()+"\"}";
	}

	/**
	 * @Brief modification d'une tache
	 */
	@RequestMapping(value="/edit", method=RequestMethod.POST, headers ={"Accept=application/json"})
	@ResponseBody
	public String editTache(@RequestBody String s){
		HashMap<String,String> r = (HashMap<String,String>) (new JSONDeserializer()).deserialize(s);
		LocalDate d = new LocalDate(new Integer(r.get("year")),new Integer(r.get("month")),
				new Integer(r.get("day")));

		Tache t = new Tache(r.get("tache"),false,d);
		t.setId(new Long(r.get("id")));
		tacheService.updateTache(t,new Long(r.get("projetId")), projetService);
		return "{\"success\" : \"true\"}";
	}

	/**
	 * @Brief suppression d'une tache
	 */
	@RequestMapping(value="/delete", method=RequestMethod.DELETE, headers ={"Accept=application/json"})
	@ResponseBody
	public String deleteTache(@RequestBody String s){
		HashMap<String,String> r = (HashMap<String,String>) (new JSONDeserializer()).deserialize(s);
		tacheService.deleteTache(new Long(r.get("id")));
		return "{\"success\" : \"true\"}";
	}
}
