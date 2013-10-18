package adhocpes.erp;

import static org.junit.Assert.*;


import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import adhocpes.erp.ref.model.Consultant;
import adhocpes.erp.ttracker.config.AppConfig;
import adhocpes.erp.ttracker.domain.Imputation;
import adhocpes.erp.ttracker.domain.Tache;
import adhocpes.erp.ttracker.services.ProjectService;


public class ImputationTest {
	private ApplicationContext context;
	private Imputation imputationt, imputationr;

	@Before
	public void setUp() throws Exception {
		context = new FileSystemXmlApplicationContext("./src/test/resources/domaintest.xml");
		imputationr = (Imputation) context.getBean("imputest");
	}

	@Test
	public final void testImputation() {
		imputationt = new Imputation();
		assertTrue(imputationt!=null);
	}

	@Test
	public final void testImputationDoubleCalendarConsultantTache() {
		imputationt = new Imputation(imputationr.getCharge(),imputationr.getJour(),
				imputationr.getConsultant(), imputationr.getTache());
		assertTrue(imputationt!=null);
		assertTrue(imputationt.equals(imputationr));
	}

	@Test
	public final void testGetCharge() {
		assertTrue(imputationr.getCharge() == 0.5);
	}
	
	@Test
	public final void testSetCharge() {
		imputationr.setCharge(0);
		assertFalse(imputationr.getCharge() == 0.5);
		imputationr.setCharge(1);
		assertTrue(imputationr.getCharge() == 1);
	}

	@Test
	public final void testGetMonth() {
		assertTrue(imputationr.getMonth() == 12);
	}

	@Test
	public final void testGetJour() {
		DateTime g = (DateTime) context.getBean("calendarImput");
		assertTrue(imputationr.getJour() != null);
		assertTrue(imputationr.getJour().equals(g));
	}

	@Test
	public final void testSetJour() {
		DateTime g = new DateTime(2014,12,01, 0, 0);
		imputationr.setJour(g);
		assertTrue(imputationr.getJour().equals(g));
	}

	@Test
	public final void testGetConsultant() {
		Consultant c = (Consultant) context.getBean("consultant");
		assertTrue(imputationr.getConsultant() != null);
		assertTrue(imputationr.getConsultant().equals(c));
	}

	@Test
	public final void testSetConsultant() {
		Consultant c = new Consultant();
		c.setConsultantId((long)12);
		c.setConsultantName("Toledo Thomas");
		assertFalse(imputationr.getConsultant().equals(c));
		imputationr.setConsultant(c);
		assertTrue(imputationr.getConsultant().equals(c));
	}

	@Test
	public final void testGetTache() {
		Tache t = (Tache) context.getBean("tacheTest");
		assertTrue(imputationr.getTache() != null);
		assertTrue(imputationr.getTache().equals(t));
	}

	@Test
	public final void testSetTache() {
		Tache t = new Tache();
		t.setDate_debut(new DateTime(2015,10,30,0,0));
		t.setFini(false);
		t.setNom("useless task");
		imputationr.setTache(t);
		assertTrue(imputationr.getTache().equals(t));
	}

}
