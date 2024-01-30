package com.ecubit.biblioteca.services.impl;

import com.ecubit.biblioteca.excepetions.ErrGestioneBiblioteca;
import com.ecubit.biblioteca.models.Biblioteca;
import com.ecubit.biblioteca.models.Libro;
import com.ecubit.biblioteca.repository.BibliotecaRepository;
import com.ecubit.biblioteca.repository.LibroRepository;
import com.ecubit.biblioteca.services.BibliotecaService;
import com.ecubit.biblioteca.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LibroServiceImpl implements LibroService {

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private BibliotecaRepository bibliotecaRepository;


    @Override
    public List<Libro> addLibro(Libro libro) throws ErrGestioneBiblioteca {
        Libro l= new Libro(libro.getAutore(), libro.getTitolo());
        List<Biblioteca> bibliotecaList=  bibliotecaRepository.findAll();
        for(Biblioteca b:bibliotecaList){
            l.setBiblioteca(b);
        }
        libroRepository.save(l);
        return libroRepository.findAll();
    }

    @Override
        public Biblioteca getBibliotecaByLibro(Libro libro) throws ErrGestioneBiblioteca {
            Optional<Biblioteca> bibliotecaOptional = libroRepository.findAll().stream()
                    .filter(l -> l.getTitolo().equals(libro.getTitolo()) && l.getAutore().equals(libro.getAutore()))
                    .map(Libro::getBiblioteca)
                    .findFirst();
            return bibliotecaOptional.orElseThrow(ErrGestioneBiblioteca::new);
        }



}
