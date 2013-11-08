package adhocpes.erp.timetracker;


import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;


import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import adhocpes.erp.domain.Consultant;
import adhocpes.erp.timetracker.domain.Imputation;
import adhocpes.erp.timetracker.domain.Tache;
import adhocpes.erp.timetracker.repository.TacheRepository;

@ContextConfiguration("classpath:test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)
public class TacheRepositoryTest {

	@Autowired
	private TacheRepository tacheRepository;
	
	@Autowired
	private Tache tacheTest;

	@Autowired
	private Consultant consultantTest;
	
	@Autowired
	private Imputation imputationTest;
	
	private Logger logger = Logger.getLogger(getClass());
	
	@Test
	public void testGlobal() throws Exception {
		testAdd();
		testEdit();
		testFindAll();
		testFindByConsultant();
		testFindByImputation();
		testDelete();
	}
	
	public void testAdd() {
		tacheRepository.save(tacheTest);		
		logger.info(tacheTest);
		Tache t = tacheRepository.findOne(tacheTest.getId());
		assertEquals(tacheTest, t);
	}

	public void testEdit() {
		tacheTest.setNom("Peuplage de la base");
		tacheRepository.save(tacheTest);
		logger.info(tacheTest);
		Tache t = tacheRepository.findOne(tacheTest.getId());
		assertEquals(tacheTest,t);
	}
	
	public void testFindAll(){
		List<Tache> res;
		res = tacheRepository.findAll();
		assertTrue(res != null);
		assertTrue(res.size()>0);
	}

	public void testFindByConsultant(){
		List<Tache> res;
		res = tacheRepository.findByConsultant(consultantTest);
		assertTrue(res != null);
		assertTrue(res.size()>0);
	}
	
	public void testFindByImputation(){
		Tache res;
		res = tacheRepository.findByImputation(imputationTest);
		assertTrue(res != null);
	}
	
	public void testDelete() {
		tacheRepository.delete(tacheTest);
		logger.info(tacheTest);
		Tache i = tacheRepository.findOne(tacheTest.getId());
		assertEquals(i, null);
	}
}
