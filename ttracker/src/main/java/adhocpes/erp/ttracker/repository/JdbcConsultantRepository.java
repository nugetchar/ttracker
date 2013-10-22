package adhocpes.erp.ttracker.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import adhocpes.erp.ref.model.Consultant;

@Repository
public class JdbcConsultantRepository implements ConsultantRepository {
	
	private JdbcTemplate jdbcTemplate;
	
	public JdbcConsultantRepository(){
		
	}
	
	public JdbcConsultantRepository(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public int getConsultantCount(){
		String sql = "SELECT COUNT(*) FROM CONSULTANT";
		return jdbcTemplate.queryForObject(sql,Integer.class);
	}
	
	@SuppressWarnings("unused")
	private class ConsultantMapper implements RowMapper<Consultant> {

		@Override
		public Consultant mapRow(ResultSet rs, int i) throws SQLException {
			Consultant c = new Consultant();
			//TODO set properties
			return c;
		}

	}

}
