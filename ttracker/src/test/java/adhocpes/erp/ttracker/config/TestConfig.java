package adhocpes.erp.ttracker.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import adhocpes.erp.ttracker.domain.Tache;


@Configuration
public class TestConfig {
	
	@Autowired
	private Environment e;
	
	public TestConfig(){
		
	}
	
	@Bean
	public Tache tacheTest(){
		return new Tache("test",false);
	}
}
