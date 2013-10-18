package adhocpes.erp.ttracker.repository;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcConsultantRepository implements ConsultantRepository {
	private JdbcTemplate jdbcTemplate;
	
	public JdbcConsultantRepository(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public int getConsultantCount(){
		String sql = "SELECT COUNT(*) FROM CONSULTANT";
		return jdbcTemplate.queryForInt(sql);
	}
}
