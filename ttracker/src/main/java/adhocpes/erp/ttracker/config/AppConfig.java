package adhocpes.erp.ttracker.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.Environment;

import adhocpes.erp.ttracker.repository.ConsultantRepository;
import adhocpes.erp.ttracker.repository.HibernateTacheRepository;
import adhocpes.erp.ttracker.repository.JdbcConsultantRepository;
import adhocpes.erp.ttracker.repository.TacheRepository;
import adhocpes.erp.ttracker.services.ConsultantServiceImpl;
import adhocpes.erp.ttracker.services.ConsultantService;
import adhocpes.erp.ttracker.services.ImputationService;
import adhocpes.erp.ttracker.services.ProjectService;
import adhocpes.erp.ttracker.services.TacheService;
import adhocpes.erp.ttracker.services.TimeSheetService;
import adhocpes.erp.ttracker.services.ImputationServiceImpl;
import adhocpes.erp.ttracker.services.ProjectServiceImpl;
import adhocpes.erp.ttracker.services.HibernateTacheService;
import adhocpes.erp.ttracker.services.TimeSheetServiceImpl;


@Configuration
@ImportResource("classpath:/META-INF/applicationContext.xml")
public class AppConfig {
	
	@Autowired
	private Environment e;
	
	@Autowired
	DataSource dataSource;
	
	
	public AppConfig(){
		
	}
	
	@Bean
	public ConsultantService consultantService(){
		return new ConsultantServiceImpl();
	}
	
	@Bean
	public TacheService hibernateTacheService(){
		return new HibernateTacheService();
	}
	
	@Bean
	public ProjectService projectService(){
		return new ProjectServiceImpl();
	}
	
	@Bean
	public ImputationService imputationService(){
		return new ImputationServiceImpl();
	}
	
	@Bean
	public TimeSheetService timeSheetService(){
		return new TimeSheetServiceImpl();
	}
	
	@Bean
	public ConsultantRepository jdbcConsultantRepository(){
		return new JdbcConsultantRepository(dataSource);
	}
	
	@Bean
	public TacheRepository hibernateTacheRepository(){
		return new HibernateTacheRepository();
	}
}
