package adhocpes.erp.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import adhocpes.erp.service.ConsultantService;
import adhocpes.erp.utils.Stringifier;


@Controller
@RequestMapping("/consultants")
public class ConsultantController {


	protected static Logger logger = Logger.getLogger("controller");

	@Autowired
	private ConsultantService consultantService;
	
	public ConsultantController(){}


	@RequestMapping("")
	public String homeConsultants(){
		return "consultants";
	}
	
	@RequestMapping("/all")
	@ResponseBody
	public String getAllProjets(){
		return Stringifier.stringifyConsultantList(consultantService.getAll());
	}
}
