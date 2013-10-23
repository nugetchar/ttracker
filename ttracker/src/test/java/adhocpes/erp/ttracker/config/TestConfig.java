package adhocpes.erp.ttracker.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import adhocpes.erp.ref.model.Consultant;
import adhocpes.erp.ref.model.Project;
import adhocpes.erp.ttracker.domain.Tache;


@Configuration
public class TestConfig {
	
	@Autowired
	private Environment e;
	
	public TestConfig(){
		
	}
	
	@Bean
	public Tache tacheTest(){
		return new Tache("test",false,null,projectTest(),consultantTest());
	}
	
	@Bean
	public Project projectTest(){
		Project p = new Project();
		p.setProjectId((long)1);
		p.setProjectName("project test");
		return p;
	}
	
	@Bean
	public Consultant consultantTest(){
		Consultant c = new Consultant();
		c.setConsultantId((long)2);
		c.setConsultantName("Thomas Toledo");
		c.setManager(false);
		c.setPassword("adhocfr1");
		return c;
	}
}
