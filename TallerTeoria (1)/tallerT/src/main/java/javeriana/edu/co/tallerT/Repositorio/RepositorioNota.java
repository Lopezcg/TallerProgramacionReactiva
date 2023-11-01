package javeriana.edu.co.tallerT.Repositorio;

import javeriana.edu.co.tallerT.Modelo.Nota;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
@Repository
public interface RepositorioNota extends ReactiveCrudRepository<Nota, Integer> {
    Flux<Nota> findByEstudianteIdAndMateriaId(Integer estudianteId, Integer materiaId);
}
