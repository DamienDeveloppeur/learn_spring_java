package fr.mds.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.mds.springdata.domain.Specie;

@Repository
public interface SpecieRepository extends JpaRepository<Specie, Long> {

}
