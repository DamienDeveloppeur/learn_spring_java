package fr.mds.springdata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.mds.springdata.domain.Person;
import fr.mds.springdata.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	public List<Person> findAll() {
		return this.personRepository.findAll();
	}

	public List<Person> testJointure(){return this.personRepository.findAll();}


	public Person create(Person person) {
		if (person.getId() != null) {
			throw new RuntimeException("id de l'entité doit être null");
		}
		return this.personRepository.save(person);
	}

	public Person update(Person person) {
		return this.personRepository.save(person);
	}

	public void delete(long id) {
		this.personRepository.deleteById(id);
	}

	public Person get(long id) {
		return this.personRepository.findById(id).orElse(null);
	}

	public Person findByFirstname(String firstname) {
		return this.personRepository.findByFirstName(firstname).orElse(null);
	}

	public List<Person> findBySpecieLike(String search) {
		return this.personRepository.findBySpecieLike("%" + search + "%");
	}

}
