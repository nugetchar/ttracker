package adhocpes.erp;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import adhocpes.erp.ttracker.config.AppConfig;
import adhocpes.erp.ttracker.config.TestConfig;
import adhocpes.erp.ttracker.domain.Tache;
import adhocpes.erp.ttracker.services.TacheService;

public class HibernateTacheServiceTest {

	ApplicationContext context,test;
	TacheService service;

	@Before
	public void setUp() throws Exception {
		context = new AnnotationConfigApplicationContext(AppConfig.class);
		test = new AnnotationConfigApplicationContext(TestConfig.class);
		service = context.getBean("hibernateTacheService",TacheService.class);
	}

	@Test
	public final void testInsertTache() {
		service.insertTache(test.getBean("tacheTest",Tache.class));
	}

	@Test
	public final void testUpdateTache() {
		Tache t = test.getBean("tacheTest",Tache.class);
		t.setFini(true);
		service.updateTache(t);
	}

	@Test
	public final void testGetAllTaches() {
		List<Tache> taches = service.findAll();
		assertTrue(taches.size()>0);
		System.out.println(taches.get(0));
	}

	@Test
	public final void testFindTachesByProject() {
		//TODO Créer projets sur la BD
	}

	@Test
	public final void testFindTachesByConsultant() {
		//TODO Créer consultants sur la BD
	}

	@Test
	public final void testFindTacheByName() {
		Tache t = service.findTacheByName("test");
		assertTrue(t!=null);
		System.out.println(t);
	}

	@Test
	public final void testDeleteTache() {
		service.deleteTache(test.getBean("tacheTest",Tache.class));
	}

}
