package fr.mds.springdata.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.mds.springdata.dao.AnimalDao;
import fr.mds.springdata.dao.SpecieDao;
import fr.mds.springdata.domain.Animal;
import fr.mds.springdata.domain.Specie;
import fr.mds.springdata.repository.PersonRepository;
import fr.mds.springdata.repository.SpecieRepository;

@Service
public class TestService {

	@Autowired
	private AnimalDao animalDao;

	@Autowired
	private SpecieDao specieDao;

	@Autowired
	private SpecieRepository specieRepository;

	@Autowired
	private PersonRepository personRepository;

	/**********************
	 * --- DAO ---
	 **********************/
	public Specie createSpecie(Specie specie) {
		long id = this.specieDao.create(specie);
		specie.setId(id);
		return specie;
	}

	public Specie getSpecie(long id) {
		return this.specieDao.get(id);
	}

	public void createAnimal(Animal animal) {
		this.animalDao.create(animal);
	}

	public List<Animal> testGetAnimal() {
		return this.animalDao.list();
	}

	/**********************
	 * --- REPOSITORY ---
	 **********************/
	@Transactional
	public List<Specie> findAllSpecies() {
		return this.specieRepository.findAll();
	}

	@Transactional
	public void testGetAllPerson() {
		this.personRepository.findAll().stream().forEach(s -> {
			System.out.println(s.toString());
		});
	}

}
