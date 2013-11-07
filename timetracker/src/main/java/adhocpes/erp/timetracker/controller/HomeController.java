package adhocpes.erp.timetracker.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import adhocpes.erp.domain.Consultant;
import adhocpes.erp.service.ConsultantService;


@Controller
@RequestMapping("")
public class HomeController {

	protected static Logger logger = Logger.getLogger("controller");

	@Autowired
	private Consultant current;
	
	@Autowired
	private ConsultantService consultantService;
	
	public HomeController(){}
	
	@RequestMapping("")
	public String getLoginView(){
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(@RequestParam String login, @RequestParam String password){
		Consultant c = consultantService.getByMailPassword("root@root.fr", "root");
		if(c == null)
			return "login";
		current.setId(c.getId());
		current.setManager(c.isManager());
		current.setEmail(c.getEmail());
		current.setNom(c.getNom());
		current.setPassword(c.getPassword());
		current.setPrenom(c.getPrenom());
		return "home";
	}
}
