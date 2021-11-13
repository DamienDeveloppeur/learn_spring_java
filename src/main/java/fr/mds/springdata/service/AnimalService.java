package fr.mds.springdata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.mds.springdata.domain.Animal;
import fr.mds.springdata.repository.AnimalRepository;

@Service
public class AnimalService {

	@Autowired
	private AnimalRepository animalRepository;

	public List<Animal> findAll() {
		return this.animalRepository.findAll();
	}

	public Animal create(Animal animal) {
		if (animal.getId() != null) {
			throw new RuntimeException("id de l'entité doit être null");
		}
		return this.animalRepository.save(animal);
	}

	public Animal update(Animal animal) {
		return this.animalRepository.save(animal);
	}

	public void delete(long id) {
		this.animalRepository.deleteById(id);
	}

	public Animal get(long id) {
		return this.animalRepository.findById(id).orElse(null);
	}

}
