package com.ecubit.biblioteca.controllers;

import com.ecubit.biblioteca.excepetions.ErrGestioneBiblioteca;
import com.ecubit.biblioteca.models.Biblioteca;
import com.ecubit.biblioteca.models.Libro;
import com.ecubit.biblioteca.services.BibliotecaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/biblioteca")
@CrossOrigin
@RestController
public class BibliotecaController {

    private Logger logger=LoggerFactory.getLogger(BibliotecaController.class);
    @Autowired
    private BibliotecaService bibliotecaService;

    @PostMapping("/add")
    public List<Biblioteca> aggiungiBiblioteca(@RequestBody Biblioteca biblioteca) throws ErrGestioneBiblioteca {
        try{
            logger.info("Biblioteca Aggiornata");
            return bibliotecaService.addBiblioteca(biblioteca);
        }catch (ErrGestioneBiblioteca e){
            throw e;
        }
    }

    @GetMapping("/get")
    public List<Libro> contiene(@RequestBody Biblioteca biblioteca) throws ErrGestioneBiblioteca {
        try{
            logger.info("Ricerca nella biblioteca");
            return bibliotecaService.findByPianoScaffaleRipiano(biblioteca);
        } catch (ErrGestioneBiblioteca e) {
            throw e;
        }
    }





}
