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

import adhocpes.erp.timetracker.domain.Imputation;
import adhocpes.erp.timetracker.repository.ImputationRepository;

@ContextConfiguration("classpath:test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)
public class ImputationRepositoryTest {

	@Autowired
	private ImputationRepository imputationRepository;

	@Autowired
	private Imputation imputationTest;

	private Logger logger = Logger.getLogger(getClass());

	@Test
	public void testGlobal() throws Exception {
		testAdd();
		testEdit();
		testFindAll();
		testFindByProjet();
		testFindByConsultant();
		testFindByTache();
		testFindByDateConsultant();
		testFindByDateTache();
		testDelete();
	}


	
	public void testAdd() {
		System.out.println("ADD IMPUTATION: " + imputationTest);
		imputationRepository.save(imputationTest);		
		logger.info(imputationTest);
		Imputation i = imputationRepository.findOne(imputationTest.getId());
		assertEquals(imputationTest, i);
	}

	public void testEdit() {
		System.out.println("EDIT IMPUTATION: " + imputationTest);
		imputationTest.setCharge(0);
		imputationRepository.save(imputationTest);
		logger.info(imputationTest);
		Imputation i = imputationRepository.findOne(imputationTest.getId());
		assertEquals(imputationTest,i);
	}

	public void testFindAll(){
		List<Imputation> res;
		res = imputationRepository.findAll();
		assertTrue(res!=null);
		assertTrue(res.size()>0);
	}
	
	public void testFindByProjet(){
		List<Imputation> res;
		res = imputationRepository.findByProjet(imputationTest.getTache().getprojet());
		assertTrue(res!=null);
		assertTrue(res.size()>0);
	}
	
	public void testFindByConsultant(){
		List<Imputation> res;
		res = imputationRepository.findByConsultant(imputationTest.getConsultant());
		assertTrue(res!=null);
		assertTrue(res.size()>0);
	}
	
	public void testFindByTache(){
		List<Imputation> res;
		res = imputationRepository.findByTache(imputationTest.getTache());
		assertTrue(res!=null);
		assertTrue(res.size()>0);
	}
	
	public void testFindByDateConsultant(){
		List<Imputation> res;
		res = imputationRepository.findByDateConsultant(imputationTest.getJour(),imputationTest.getConsultant());
		assertTrue(res!=null);
		assertTrue(res.size()>0);
	}

	public void testFindByDateProjet(){
		List<Imputation> res;
		res = imputationRepository.findByDateProjet(imputationTest.getJour(),imputationTest.getTache().getprojet());
		assertTrue(res!=null);
		assertTrue(res.size()>0);
	}

	public void testFindByDateTache(){
		Imputation res;
		res = imputationRepository.findByDateTache(imputationTest.getJour(),imputationTest.getTache());
		assertTrue(res!=null);
	}

	public void testDelete() {
		System.out.println("DELETE IMPUTATION: " + imputationTest);
		imputationRepository.delete(imputationTest.getId());
		imputationRepository.flush();
		logger.info(imputationTest);
		Imputation i = imputationRepository.findOne(imputationTest.getId());
		assertNull(i);
	}

}
