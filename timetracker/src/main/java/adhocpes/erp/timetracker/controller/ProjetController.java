package adhocpes.erp.timetracker.controller;



import java.util.List;

import adhocpes.erp.service.ProjetService;
import adhocpes.erp.domain.Consultant;
import adhocpes.erp.domain.Projet;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping("/projets")
public class ProjetController {

	protected static Logger logger = Logger.getLogger("controller");

	@Autowired
	private ProjetService projetService;
	
	@Autowired
	private Consultant current;
	
	public ProjetController(){}

	@RequestMapping("/projets")
	@ResponseBody
	public String getAllProjets(){
		String res="<select>";
		List<Projet> projets = projetService.getAll();
		for(Projet p : projets)
			res += "<option value='"+p.getId()+"'>"+p.getNom()+"</option>";
		res += "</select>";
		return res;
	}
	

	@RequestMapping("/affectes")
	@ResponseBody
	public String getProjetsAffectes(){
		String res="<select>";
		List<Projet> projets = projetService.getProjetsAffectes(current) ;
		for(Projet p : projets)
			res += "<option value='"+p.getId()+"'>"+p.getNom()+"</option>";
		res += "</select>";
		return res;
	}

}
