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

import adhocpes.erp.timetracker.domain.Imputation;
import adhocpes.erp.timetracker.services.ImputationService;

@ContextConfiguration("classpath:test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class ImputationServiceTest {

	@Autowired
	private ImputationService imputationService;

	@Autowired
	private Imputation i;
	
	@Test
	public void testGlobal(){
	}

	@Test
	public final void testInsertImputation() {
		System.out.println("Insert imputation");
		imputationService.insertImputation(i);
		Imputation j = imputationService.getOne(i.getId());
		assertTrue(j != null);
		assertEquals(j,i);
	}

	@Test
	public final void testUpdateImputation() {
		System.out.println("Update imputation");
		Imputation j;
		i.setCharge(0);
		imputationService.updateImputation(i);
		j = imputationService.getOne(i.getId());
		assertTrue(j != null);
		assertEquals(j,i);
	}

	@Test
	public final void testGetOne() {
		System.out.println("GetOne");
		Imputation j = imputationService.getOne(i.getId());
		assertTrue(j != null);
		assertEquals(j,i);
	}
	
	@Test
	public final void testGetAll() {
		List<Imputation> imputations;
		imputations = imputationService.getAll();
		assertTrue(imputations != null);
		assertTrue(imputations.size()>0);
		
	}

	@Test
	public final void testGetImputationsByProjet() {
		List<Imputation> imputations;
		imputations = imputationService.getImputationsByProjet(i.getTache().getprojet());
		assertTrue(imputations != null);
		assertTrue(imputations.size()>0);
	}

	@Test
	public final void testGetImputationsByConsultant() {
		List<Imputation> imputations;
		imputations = imputationService.getImputationsByConsultant(i.getConsultant());
		assertTrue(imputations != null);
		assertTrue(imputations.size()>0);
	}

	@Test
	public final void testGetImputationsByTache() {
		List<Imputation> imputations;
		imputations = imputationService.getImputationsByTache(i.getTache());
		assertTrue(imputations != null);
		assertTrue(imputations.size()>0);
	}

	@Test
	public final void testGetByDateConsultant() {
		List<Imputation> imputations;
		imputations = imputationService.getByDateConsultant(i.getJour(), i.getConsultant());
		assertTrue(imputations != null);
		assertTrue(imputations.size()>0);
	}

	@Test
	public final void testGetByDateProjet() {
		List<Imputation> imputations;
		imputations = imputationService.getByDateProjet(i.getJour(), i.getTache().getprojet());
		assertTrue(imputations != null);
		assertTrue(imputations.size()>0);
	}

	@Test
	public final void testGetByDateTache() {
		Imputation imputations;
		imputations = imputationService.getByDateTache(i.getJour(), i.getTache());
		assertTrue(imputations != null);
		assertEquals(imputations,i);
	}

	@Test
	public final void testDeleteImputation() {
		imputationService.deleteImputation(i);
		Imputation j = imputationService.getOne(i.getId());
		assertTrue(j == null);
	}
}
