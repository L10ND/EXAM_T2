package edu.cibertec.T2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cibertec.T2.model.Libro;

@Repository
public interface ILibroRepository extends JpaRepository<Libro, Integer> {

}
