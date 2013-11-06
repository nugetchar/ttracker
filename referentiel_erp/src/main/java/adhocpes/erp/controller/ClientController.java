package adhocpes.erp.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import adhocpes.erp.service.ClientService;
import adhocpes.erp.utils.Stringifier;


@Controller
@RequestMapping("/clients")
public class ClientController {


	protected static Logger logger = Logger.getLogger("controller");

	@Autowired
	private ClientService clientService;
	
	public ClientController(){}


	@RequestMapping("")
	public String homeConsultants(){
		return "clients";
	}
	
	@RequestMapping("/all")
	@ResponseBody
	public String getAllProjets(){
		return Stringifier.stringifyClientList(clientService.getAll());
	}
}
