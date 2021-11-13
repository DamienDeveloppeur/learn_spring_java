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
import org.springframework.web.bind.annotation.RestController;

import fr.mds.springdata.domain.Animal;
import fr.mds.springdata.service.AnimalService;

@RestController
@RequestMapping("/api/animal")
public class AnimalController {

	@Autowired
	private AnimalService animalService;

	@Transactional
	@GetMapping
	public List<Animal> findAll() {
		return animalService.findAll();
	}

	@Transactional
	@GetMapping("/{id}")
	public Animal get(@PathVariable(name = "id") long id) {
		return animalService.get(id);
	}

	@Transactional
	@PostMapping
	public Animal create(@RequestBody Animal animal) {
		return animalService.create(animal);
	}

	@Transactional
	@PutMapping
	public Animal update(@RequestBody Animal animal) {
		return animalService.update(animal);
	}

	@Transactional
	@DeleteMapping("/{id}")
	public void delete(@PathVariable(name = "id") long id) {
		animalService.delete(id);
	}
}
