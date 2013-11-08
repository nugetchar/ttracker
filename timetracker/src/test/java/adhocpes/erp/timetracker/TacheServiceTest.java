package adhocpes.erp.timetracker;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import adhocpes.erp.domain.Consultant;
import adhocpes.erp.timetracker.domain.Imputation;
import adhocpes.erp.timetracker.domain.Tache;
import adhocpes.erp.timetracker.services.TacheService;

@ContextConfiguration("classpath:test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class TacheServiceTest {

	@Autowired
	private TacheService tacheService;
	
	@Autowired
	private Tache t;
	
	@Autowired
	private Consultant c;
	
	@Autowired
	private Imputation i;
	
	@Test
	public void setUp() throws Exception {
		testInsertTache();
		testUpdateTache();
		testGetAll();
		testGetOne();
		testGetTachesByProject();
		testGetTachesByConsultant();
		testGetByImputation();
		testDeleteTache();
	}
	
	public final void testInsertTache() {
		tacheService.insertTache(t);
		Tache u = tacheService.getOne(t.getId());
		assertTrue(u != null);
		assertEquals(u,t);
	}

	public final void testUpdateTache() {
		t.setNom("tache fake");
		tacheService.updateTache(t);
		Tache u = tacheService.getOne(t.getId());
		assertTrue(u != null);
		assertEquals(u,t);
	}

	public final void testGetAll() {
		List<Tache> taches;
		taches = tacheService.getAll();
		assertTrue(taches != null);
		assertTrue(taches.size()>0);
	}

	public final void testGetOne() {
		Tache tache;
		tache = tacheService.getOne(t.getId());
		assertTrue(tache != null);
		assertEquals(t,tache);
	}

	public final void testGetTachesByProject() {
		List<Tache> taches;
		taches = tacheService.getTachesByProject(t.getprojet());
		assertTrue(taches != null);
		assertTrue(taches.size()>0);
	}

	public final void testGetTachesByConsultant() {
		
		List<Tache> taches;
		taches = tacheService.getTachesByConsultant(c);
		assertTrue(taches != null);
		assertTrue(taches.size()>0);
	}

	public final void testGetByImputation() {
		Tache tache;
		tache = tacheService.getByImputation(i);
		assertTrue(tache != null);
	}

	public final void testDeleteTache() {
		tacheService.deleteTache(t);
		Tache tache = tacheService.getOne(t.getId());
		assertTrue(tache == null);
	}
}
