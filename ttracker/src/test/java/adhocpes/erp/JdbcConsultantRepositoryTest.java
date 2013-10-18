package adhocpes.erp;


import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import adhocpes.erp.ttracker.config.AppConfig;
import adhocpes.erp.ttracker.repository.ConsultantRepository;

public class JdbcConsultantRepositoryTest {

	private ApplicationContext context;
	private ConsultantRepository dao;
	@Before
	public void setUp() throws Exception {
		try{
			context = new AnnotationConfigApplicationContext(AppConfig.class);
		}catch(Exception e){
			System.out.println(e);
		}
	}

	@Test
	public final void testJdbcConsultantRepository() {
		//dao = context.getBean("jdbcConsultantRepository",ConsultantRepository.class);
	}

	@Test
	public final void testGetConsultantCount() {
		//System.out.println(dao.getConsultantCount());
	}

}
