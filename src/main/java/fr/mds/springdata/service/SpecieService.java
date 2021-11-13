package fr.mds.springdata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.mds.springdata.domain.Specie;
import fr.mds.springdata.repository.SpecieRepository;

@Service
public class SpecieService {

	@Autowired
	private SpecieRepository specieRepository;

	public List<Specie> findAll() {
		return this.specieRepository.findAll();
	}

	public Specie create(Specie specie) {
		if (specie.getId() != 0) {
			throw new RuntimeException("id de l'entité doit être null");
		}
		return this.specieRepository.save(specie);
	}

	public Specie update(Specie specie) {
		return this.specieRepository.save(specie);
	}

	public void delete(long id) {
		this.specieRepository.deleteById(id);
	}

	public Specie get(long id) {
		return this.specieRepository.findById(id).orElse(null);
	}

}
