package adhocpes.erp;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import adhocpes.erp.ttracker.config.*;
import adhocpes.erp.ttracker.domain.Tache;
import adhocpes.erp.ttracker.repository.TacheRepository;


public class HibernateTacheRepositoryTest {

	ApplicationContext context,test;
	TacheRepository dao;
	
	@Before
	public void setUp() throws Exception {
		context = new AnnotationConfigApplicationContext(AppConfig.class);
		test = new AnnotationConfigApplicationContext(TestConfig.class);
		dao = context.getBean("hibernateTacheRepository",TacheRepository.class);
	}

	@Test
	public final void testHibernateTacheRepository() {
	}

	@Test
	public final void testInsertTache() {
		dao.insertTache(test.getBean("tacheTest",Tache.class));
	}
	
	@Test
	public final void testUpdateTache() {
		Tache t = test.getBean("tacheTest",Tache.class);
		t.setFini(true);
		dao.updateTache(t);
	}

	@Test
	public final void testGetTache() {
		Tache t = dao.getTache(test.getBean("tacheTest",Tache.class).getNom());
		assertTrue(t!=null);
	}

	@Test
	public final void testGetAllTaches() {
		List<Tache> taches = dao.getAllTaches();
		assertTrue(taches!=null);
	}
	
	@Test
	public final void testDeleteTache() {
		dao.deleteTache(test.getBean("tacheTest",Tache.class));
	}

}



