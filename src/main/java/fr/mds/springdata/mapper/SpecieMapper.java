package fr.mds.springdata.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.mds.springdata.domain.Specie;

public class SpecieMapper implements RowMapper<Specie> {
	String id;

	public SpecieMapper() {
		this("id");
	}

	public SpecieMapper(String id) {
		this.id = id;
	}

	@Override
	public Specie mapRow(ResultSet rs, int rowNum) throws SQLException {
		Specie sp = new Specie(rs.getLong(id), rs.getString("common_name"), rs.getString("latin_name"));
		return sp;
	}

}
