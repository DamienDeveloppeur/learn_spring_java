package fr.mds.springdata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.mds.springdata.domain.Person;
import fr.mds.springdata.service.PersonService;

@RestController
@RequestMapping("/api/person")
public class PersonController {

	@Autowired
	private PersonService personService;

	@Transactional
	@GetMapping
	public List<Person> findAll() {
		return personService.findAll();
	}

	@Transactional
	@GetMapping("/{id}")
	public Person get(@PathVariable(name = "id") long id) {
		return personService.get(id);
	}

	@Transactional
	@PostMapping
	public Person create(@RequestBody Person person) {
		return personService.create(person);
	}


	@Transactional
	@PutMapping
	public Person update(@RequestBody Person person) {
		return personService.update(person);
	}

	@Transactional
	@DeleteMapping("/{id}")
	public void delete(@PathVariable(name = "id") long id) {
		personService.delete(id);
	}

	@Transactional
	@GetMapping("/firstname/{search}")
	public Person findByFirstName(@PathVariable(name = "search") String search) {
		// exemple de requête avec un @PathVarialbe -> nom du paramètre entre parenthèse
		// /firstname/VALEUR -> récupère une element du path de la requête
		// example : http://localhost:8080/api/person/firstname/sacha
		return personService.findByFirstname(search);
	}

	@Transactional
	@GetMapping("/specie")
	public @ResponseBody List<Person> findBySpecieLike(@RequestParam(name = "search") String search) {
		// exemple de requête avec un @RequestParam -> nom du paramètre entre parenthèse
		// ?chien= -> correspondance dans la requête
		// http://localhost:8080/api/person/specie?search=chien
		return personService.findBySpecieLike(search);
	}
}
