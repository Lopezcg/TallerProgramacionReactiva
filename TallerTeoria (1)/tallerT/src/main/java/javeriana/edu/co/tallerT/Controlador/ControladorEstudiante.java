package javeriana.edu.co.tallerT.Controlador;

import java.util.List;

import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;



import javeriana.edu.co.tallerT.Modelo.Estudiante;

import javeriana.edu.co.tallerT.Repositorio.RepositorioEstudiante;



@RestController

@RequestMapping("/api/")

public class ControladorEstudiante {

    @Autowired
    private RepositorioEstudiante repositorioEstudiante;

    @PostMapping("/crea")

    public ResponseEntity<Estudiante> creaEstudiante(@RequestBody Estudiante estudiante)

    {

        Estudiante nuevoEstudiante =  repositorioEstudiante.save(estudiante);

        return new ResponseEntity<>(nuevoEstudiante, HttpStatus.CREATED);

    }



    @GetMapping("/estudiantes")

    public List<Estudiante> traeEstudiantes() {

        return repositorioEstudiante.findAll();

    }



    @GetMapping("/estudiante/{id}")

    public Optional<Estudiante> traeUnEstudiante(@PathVariable Integer id) {

        return repositorioEstudiante.findById(id);

    }



    @PutMapping("/actualiza/{id}")

    public ResponseEntity<Estudiante> actualizaEstudiante(@PathVariable Integer id, @RequestBody Estudiante estudiante) {

        Optional<Estudiante> estudianteActual = repositorioEstudiante.findById(id);

        if (estudianteActual == null) {

            return new ResponseEntity<Estudiante>(HttpStatus.NOT_FOUND);

        }



        estudianteActual.get().setNombre(estudiante.getNombre());

        estudianteActual.get().setApellido(estudiante.getApellido());

        estudianteActual.get().setCorreo(estudiante.getCorreo());

        repositorioEstudiante.save(estudianteActual.get());

        return new ResponseEntity<Estudiante>(HttpStatus.OK);



    }



    @DeleteMapping("/borra/{id}")

    public ResponseEntity<HttpStatus> borraEstudiante(@PathVariable Integer id) {

        Optional<Estudiante> estudiante = repositorioEstudiante.findById(id);

        if (estudiante == null) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

        repositorioEstudiante.delete(estudiante.get());

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);



    }

}