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

import fr.mds.springdata.domain.Specie;
import fr.mds.springdata.service.SpecieService;

@RestController
@RequestMapping("/api/specie")
public class SpecieApiController {

	@Autowired
	private SpecieService specieService;

	@Transactional
	@GetMapping
	public List<Specie> findAll() {
		return specieService.findAll();
	}


	@Transactional
	@GetMapping("/{id}")
	public Specie get(@PathVariable(name = "id") long id) {

		return specieService.get(id);
	}

	@Transactional
	@PostMapping
	public Specie create(@RequestBody Specie specie) {
		return specieService.create(specie);
	}

	@Transactional
	@PutMapping
	public Specie update(@RequestBody Specie specie) {
		return specieService.update(specie);
	}

	@Transactional
	@DeleteMapping("/{id}")
	public void delete(@PathVariable(name = "id") long id) {
		specieService.delete(id);
	}
}
