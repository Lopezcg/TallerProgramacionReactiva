package javeriana.edu.co.tallerT.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import javeriana.edu.co.tallerT.Modelo.Estudiante;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioEstudiante extends JpaRepository<Estudiante, Integer> {


}