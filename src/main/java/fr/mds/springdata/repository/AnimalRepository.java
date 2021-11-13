package fr.mds.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.mds.springdata.domain.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
	
}
