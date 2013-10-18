package adhocpes.erp.ttracker.services;

import java.util.List;

import adhocpes.erp.ttracker.domain.Imputation;


public interface TimeSheetService {
	
	//Retrieving timesheet
	//TODO définir paramètres
	public List<Imputation> getTimeSheetMonthConsultant();
	public List<Imputation> getTimeSheetMonthConsultantProject();
	public List<Imputation> getTimeSheetMonthConsultantTask();
	
}
