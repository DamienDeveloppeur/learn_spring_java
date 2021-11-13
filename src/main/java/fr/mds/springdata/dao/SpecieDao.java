package fr.mds.springdata.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import fr.mds.springdata.domain.Specie;
import fr.mds.springdata.mapper.SpecieMapper;

@Repository
public class SpecieDao {
	private JdbcTemplate jdbcTemplate = new JdbcTemplate();

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate.setDataSource(dataSource);
	}

	public int count() {
		return jdbcTemplate.queryForObject("select count(*) from specie", Integer.class);
	}

	public List<Specie> list() {
		return jdbcTemplate.query("select * from specie", new SpecieMapper());
	}

	public Specie get(long id) {
		return jdbcTemplate.queryForObject("select * from specie where id = ?", new Object[] { id },
				new SpecieMapper());
	}

	public long create(Specie sp) {
		jdbcTemplate.update("insert into specie (common_name,latin_name) values (?,?)", sp.getCommonName(),
				sp.getLatinName());
		long id = jdbcTemplate.queryForObject("SELECT MAX(id) AS id from specie", Long.class);
		return id;
	}

	public void delete(long id) {
		jdbcTemplate.update("delete from specie where id=?", id);
	}

	public void update(Specie sp) {
		jdbcTemplate.update("update specie set common_name = ?, latin_name=? where id=?", sp.getCommonName(),
				sp.getLatinName(), sp.getId());
	}
}
