package com.ecubit.biblioteca.controllers;

import com.ecubit.biblioteca.excepetions.ErrGestioneBiblioteca;
import com.ecubit.biblioteca.models.Biblioteca;
import com.ecubit.biblioteca.models.Libro;
import com.ecubit.biblioteca.services.LibroService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/libro")
@CrossOrigin
@RestController
public class LibroController {

    Logger logger= LoggerFactory.getLogger(LibroController.class);

    @Autowired
    private LibroService libroService;


    @PostMapping("/add")
    public List<Libro> addLibroInBiblioteca(@RequestBody Libro libro) throws ErrGestioneBiblioteca {
        try {
            List<Libro> libri= libroService.addLibro(libro);
            logger.info("Libro aggiunto");
            return libri;
        }catch(ErrGestioneBiblioteca e){
            throw e;
        }
    }

    @GetMapping("/get")
    public Biblioteca getBibliotecaByLibro(@RequestBody Libro libro) throws ErrGestioneBiblioteca {
        try{
            Biblioteca biblioteca= libroService.getBibliotecaByLibro(libro);
            logger.info("Trovata biblioteca selezionata");
            return biblioteca;
        }catch (ErrGestioneBiblioteca e){
            throw e;
        }
    }
}
