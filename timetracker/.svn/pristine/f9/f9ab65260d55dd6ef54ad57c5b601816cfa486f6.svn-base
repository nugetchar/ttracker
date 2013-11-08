package adhocpes.erp.timetracker.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import adhocpes.erp.domain.Consultant;
import adhocpes.erp.service.ConsultantService;


@Controller
@RequestMapping("/consultants")
public class ConsultantController {
	protected static Logger logger = Logger.getLogger("controller");

	@Autowired
	private ConsultantService consultantService;
	
	
	@RequestMapping("/consultants")
	@ResponseBody
	public String getAllConsultants(){
		String res="<select>";
		List<Consultant> consultants = consultantService.getAll();
		for(Consultant c : consultants)
			res += "<option value='"+c.getId()+"'>"+c.getNom()+"</option>";
		res += "</select>";
		return res;
	}
}
