package adhocpes.erp.timetracker.controller;


import flexjson.JSONSerializer;

import java.util.List;

import adhocpes.erp.timetracker.services.TacheService;
import adhocpes.erp.timetracker.domain.Tache;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping("/taches")
public class TacheController {

	protected static Logger logger = Logger.getLogger("controller");
	
	@Autowired
	private TacheService tacheService;

	public TacheController(){}
	
	/**
	* @Brief liste toutes les tâches existantes. On se base ici
	* sur le plug-in jqgrid, lequel permettra la suppression, modification, ajout de tâches
	*/
	@RequestMapping("")

	public String listAll(){
		return "tacheslist";
	}

	/**
	* @Brief fournit à jqgrid la liste des tâches en JSON
	*/
	@RequestMapping("/manage")
	@ResponseBody
	public String retrieveTaches(){
		List<Tache> taches = tacheService.getAll();
		String res="[" + taches.get(0);
		for(int i=1; i<taches.size(); ++i)
			res += "," + taches.get(i);
		res += "]";
		return res;
	}

	
}
