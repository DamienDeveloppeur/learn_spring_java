package fr.mds.springdata.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

import fr.mds.springdata.domain.Animal;
import fr.mds.springdata.domain.Person;
import fr.mds.springdata.domain.Specie;

public class PersonMapper implements RowMapper<Person> {

	private Map<Long, Person> map = new HashMap<Long, Person>();

	public void clear() {
		map = new HashMap<Long, Person>();
	}

	@Override
	public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
		Specie sp = new SpecieMapper("sid").mapRow(rs, 0);
		Animal an = null;
		Long aid = rs.getLong("aid");
		if (aid != null && aid != 0L) {
			an = new AnimalMapper("aid").mapRow(rs, 0);
			an.setSpecie(sp);
		}
		Long id = rs.getLong("id");
		Person p = map.get(id);
		if (p == null) {
			p = new Person(rs.getLong("id"), rs.getString("firstname"), rs.getString("lastName"), rs.getInt("age"));
			map.put(id, p);
		}
		if (an != null) {
			p.getAnimals().add(an);
		}
		return p;
	}

}
