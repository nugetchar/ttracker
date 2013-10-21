package adhocpes.erp;

import static org.junit.Assert.*;


import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import adhocpes.erp.ttracker.domain.Tache;

public class TacheTest {
	private ApplicationContext context;
	private Tache tache_test,tache_ref;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		context = new FileSystemXmlApplicationContext("./src/test/resources/domaintest.xml");
		tache_ref = (Tache) context.getBean("tacheTest");
	}

	/**
	 * Test method for {@link adhocpes.erp.domains.Tache#Tache()}.
	 */
	@Test
	public final void testTache() {
		tache_test = new Tache();
		assertTrue(tache_test!=null);
	}

	/**
	 * Test method for {@link adhocpes.erp.domains.Tache#Tache(java.lang.String, boolean, java.util.Calendar)}.
	 */
	@Test
	public final void testTacheStringBooleanCalendar() {
		tache_test = new Tache(tache_ref.getNom(),tache_ref.isFini(),tache_ref.getDate_debut());
		assertTrue(tache_test!=null);
		assertTrue(tache_test.equals(tache_ref));
	}

	/**
	 * Test method for {@link adhocpes.erp.domains.Tache#getNom()}.
	 */
	@Test
	public final void testGetNom() {
		assertTrue(tache_ref.getNom().equals("test"));
	}

	/**
	 * Test method for {@link adhocpes.erp.domains.Tache#setNom(java.lang.String)}.
	 */
	@Test
	public final void testSetNom() {
		tache_ref.setNom("toto");
		assertTrue(tache_ref.getNom() == "toto");
		tache_ref.setNom("titi");
		assertTrue(tache_ref.getNom() == "titi");
	}

	/**
	 * Test method for {@link adhocpes.erp.domains.Tache#isFini()}.
	 */
	@Test
	public final void testIsFini() {
		assertFalse(tache_ref.isFini());
	}

	/**
	 * Test method for {@link adhocpes.erp.domains.Tache#setFini(boolean)}.
	 */
	@Test
	public final void testSetFini() {
		tache_ref.setFini(true);
		assertTrue(tache_ref.isFini());
	}

	/**
	 * Test method for {@link adhocpes.erp.domains.Tache#getDate_debut()}.
	 */
	@Test
	public final void testGetDate_debut() {
		assertTrue(tache_ref.getDate_debut().getDayOfMonth() == 31);
		assertTrue(tache_ref.getDate_debut().getMonthOfYear() == 12);
		assertTrue(tache_ref.getDate_debut().getYear() == 2013);
	}

	/**
	 * Test method for {@link adhocpes.erp.domains.Tache#setDate_debut(java.util.Calendar)}.
	 */
	@Test
	public final void testSetDate_debut() {
		tache_ref.setDate_debut(new DateTime(2014,1,1,0,0));
		assertTrue(tache_ref.getDate_debut().getDayOfMonth() == 1);
		assertTrue(tache_ref.getDate_debut().getMonthOfYear() == 1);
		assertTrue(tache_ref.getDate_debut().getYear() == 2014);
	}

}
