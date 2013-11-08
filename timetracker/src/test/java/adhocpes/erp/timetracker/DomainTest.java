package adhocpes.erp.timetracker;


import org.apache.log4j.Logger;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import adhocpes.erp.domain.*;
import adhocpes.erp.timetracker.domain.Imputation;
import adhocpes.erp.timetracker.domain.Tache;

@ContextConfiguration("classpath:domainBeans-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class DomainTest {
	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	private Projet prj;
	@Autowired
	private Consultant csl;
	@Autowired
	private Client clt;
	@Autowired
	private Imputation imputation;
	@Autowired
	private Tache tache;

	@Test
	public void domainBeansTest() {
		logger.info(csl + "  Hash : " + csl.hashCode());
		logger.info(clt + "  Hash : " + clt.hashCode());
		logger.info(prj + "  Hash : " + prj.hashCode());
		logger.info(tache + "  Hash : " + tache.hashCode());
		logger.info(imputation + "  Hash : " + imputation.hashCode());
	}
	
}
