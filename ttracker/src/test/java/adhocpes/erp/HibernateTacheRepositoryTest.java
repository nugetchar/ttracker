package adhocpes.erp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import adhocpes.erp.ttracker.config.AppConfig;
import adhocpes.erp.ttracker.domain.Tache;
import adhocpes.erp.ttracker.repository.TacheRepository;

public class HibernateTacheRepositoryTest {

	ApplicationContext context;
	TacheRepository dao;
	@Before
	public void setUp() throws Exception {
		context = new AnnotationConfigApplicationContext(AppConfig.class);
		dao = context.getBean("hibernateTacheRepository",TacheRepository.class);
	}

	@Test @Transactional
	public final void testInsertTache() {
		Tache t = new Tache("test",false);
		System.out.println(t.getDate_debut());
		dao.insertTache(t);
	}

}
