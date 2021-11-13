package fr.mds.springdata.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.mds.springdata.domain.Animal;
import fr.mds.springdata.domain.Specie;

public class AnimalMapper implements RowMapper<Animal> {
	private String id;

	public AnimalMapper() {
		this("id");
	}

	public AnimalMapper(String id) {
		this.id = id;
	}

	@Override
	public Animal mapRow(ResultSet rs, int rowNum) throws SQLException {
		Specie sp = new SpecieMapper("sid").mapRow(rs, 0);
		Animal an = new Animal(rs.getLong(id), rs.getString("name"), rs.getString("color"), rs.getString("sex"), sp);
		return an;
	}

}
