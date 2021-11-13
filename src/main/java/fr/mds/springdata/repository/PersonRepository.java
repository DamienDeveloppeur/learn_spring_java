package fr.mds.springdata.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.mds.springdata.domain.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

	public Optional<Person> findByFirstName(String firstName);

	@Query("SELECT DISTINCT p FROM Person p INNER JOIN p.animals a INNER JOIN a.specie s WHERE LOWER(s.commonName) LIKE :search")
	public List<Person> findBySpecieLike(@Param("search") String search);
}
