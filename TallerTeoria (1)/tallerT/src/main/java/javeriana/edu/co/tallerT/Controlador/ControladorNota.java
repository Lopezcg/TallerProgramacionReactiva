package javeriana.edu.co.tallerT.Controlador;




import javeriana.edu.co.tallerT.Modelo.Nota;
import javeriana.edu.co.tallerT.Repositorio.RepositorioNota;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;



import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@RestController

@RequestMapping("/api/nota")

public class ControladorNota {

    private final RepositorioNota repositorioNota;

    public ControladorNota(RepositorioNota repositorioNota) {
        this.repositorioNota = repositorioNota;
    }

    @PostMapping
    public Mono<Nota> crearNota(@RequestBody Nota nota) {
        return repositorioNota.save(nota);
    }

    @GetMapping("/{id}")
    public Mono<Nota> obtenerNotaPorId(@PathVariable("id") Integer id) {
        return repositorioNota.findById(id);
    }

    @PutMapping("/{id}")
    public Mono<Nota> actualizarNota(@PathVariable("id") Integer id, @RequestBody Nota notaActualizada) {
        return repositorioNota.findById(id)
                .flatMap(nota -> {
                    nota.setObservacion(notaActualizada.getObservacion());
                    nota.setValor(notaActualizada.getValor());
                    return repositorioNota.save(nota);
                });
    }

    @DeleteMapping("/{id}")
    public Mono<Void> eliminarNota(@PathVariable("id") Integer id) {
        return repositorioNota.deleteById(id);
    }

    @GetMapping
    public Flux<Nota> obtenerTodasLasNotas() {
        return repositorioNota.findAll();
    }
}