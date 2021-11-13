package fr.mds.springdata.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import fr.mds.springdata.domain.Animal;
import fr.mds.springdata.mapper.AnimalMapper;

@Repository
public class AnimalDao {
	private JdbcTemplate jdbcTemplate = new JdbcTemplate();

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate.setDataSource(dataSource);
	}

	public List<Animal> list() {
		return jdbcTemplate.query(
				"SELECT a.id,a.color,a.sex,a.name,s.ID AS sid,s.COMMON_NAME,s.LATIN_NAME FROM animal a JOIN specie s ON a.ID_SPECIE=s.id",
				new AnimalMapper());
	}

	public List<Animal> get(Long id) {
		return jdbcTemplate.query(
				"SELECT a.id,a.color,a.sex,a.name,s.ID AS sid,s.COMMON_NAME,s.LATIN_NAME FROM animal a JOIN specie s ON a.ID_SPECIE=s.id where a.id=?",
				new AnimalMapper(), id);
	}

	public void create(Animal an) {
		jdbcTemplate.update("insert into animal (name,color,sex,id_specie) values (?,?,?,?)", an.getName(),
				an.getColor(), an.getSex(), an.getSpecie().getId());
	}

	public void update(Animal an) {
		jdbcTemplate.update("update animal set name = ?, color=?, sex=?,id_specie=? where id=?", an.getName(),
				an.getColor(), an.getSex(), an.getSpecie().getId(), an.getId());
	}

	public void delete(long id) {
		jdbcTemplate.update("delete from animal where id=?", id);
	}
}
