package fr.mds.springdata.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import fr.mds.springdata.domain.Animal;
import fr.mds.springdata.domain.Person;
import fr.mds.springdata.mapper.PersonMapper;

@Repository
public class PersonDao {
	private JdbcTemplate jdbcTemplate = new JdbcTemplate();

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate.setDataSource(dataSource);
	}

	public List<Person> list() {
		PersonMapper mapper = new PersonMapper();
		mapper.clear();
		final List<Person> list = jdbcTemplate.query(
				"SELECT p.id AS id,firstname,lastname,age,a.id as aid,s.ID AS sid,NAME,color,sex,common_name,latin_name  FROM person p LEFT OUTER JOIN person__animal pa ON pa.person_id = p.id LEFT outer JOIN animal a ON pa.animal_id=a.id LEFT OUTER JOIN specie s ON a.id_specie=s.id",
				mapper);
		final List<Person> retList = new ArrayList<Person>();
		list.stream().filter(p -> !retList.contains(p)).forEach(p -> retList.add(p));
		return retList;
	}

	public List<Person> get(Long id) {
		PersonMapper mapper = new PersonMapper();
		final List<Person> list = jdbcTemplate.query(
				"SELECT p.id AS id,firstname,lastname,age,a.id as aid,s.ID AS sid,NAME,color,sex,common_name,latin_name  FROM person p LEFT OUTER JOIN person__animal pa ON pa.person_id = p.id LEFT outer JOIN animal a ON pa.animal_id=a.id LEFT OUTER JOIN specie s ON a.id_specie=s.id where p.id=?",
				mapper, id);
		return list;
	}

	public void create(Person p) {
		jdbcTemplate.update("insert into person (firstname,lastname,age) values (?,?,?)", p.getFirstName(),
				p.getLastName(), p.getAge());
		long id = jdbcTemplate.queryForObject("SELECT MAX(id) AS id from person", Long.class);
		for (Animal a : p.getAnimals()) {
			jdbcTemplate.update("insert into person__animal (person_id,animal_id) values (?,?)", id, a.getId());
		}
	}

	public void update(Person p) {
		jdbcTemplate.update("update person set firstname = ?,lastname = ?, age = ? where id=?", p.getFirstName(),
				p.getLastName(), p.getAge(), p.getId());
		jdbcTemplate.update("delete from person__animal where person_id=?", p.getId());

		for (Animal a : p.getAnimals()) {
			jdbcTemplate.update("insert into person__animal (person_id,animal_id) values (?,?)", p.getId(), a.getId());
		}
	}

	public void delete(long id) {
		jdbcTemplate.update("delete from person__animal where person_id=?", id);
		jdbcTemplate.update("delete from person where id=?", id);
	}
}
