package adhocpes.erp.timetracker.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.Environment;


@Configuration
@ImportResource("classpath:domainBeans-context.xml")
public class AppConfig {
	
	@Autowired
	private Environment e;
	
	public AppConfig(){
		
	}
}
