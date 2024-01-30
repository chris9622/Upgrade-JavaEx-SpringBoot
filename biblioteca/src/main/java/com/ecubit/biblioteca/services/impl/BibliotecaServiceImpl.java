package com.ecubit.biblioteca.services.impl;

import com.ecubit.biblioteca.excepetions.ErrGestioneBiblioteca;
import com.ecubit.biblioteca.models.Biblioteca;
import com.ecubit.biblioteca.models.Libro;
import com.ecubit.biblioteca.repository.BibliotecaRepository;
import com.ecubit.biblioteca.services.BibliotecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BibliotecaServiceImpl implements BibliotecaService {

    @Autowired
    private BibliotecaRepository bibliotecaRepository;


    public List<Biblioteca> addBiblioteca(Biblioteca biblioteca) throws ErrGestioneBiblioteca {
        Biblioteca b = new Biblioteca(biblioteca.getPiano(), biblioteca.getScaffale(), biblioteca.getRipiano());
        List<Libro> libri = biblioteca.getLibri().stream()
                .map(l -> {
                    Libro libro = new Libro(l.getTitolo(), l.getAutore());
                    libro.setBiblioteca(b);
                    return libro;
                })
                .collect(Collectors.toList());

        b.setLibri(libri);
        bibliotecaRepository.save(b);

        return bibliotecaRepository.findAll();
    }


    @Override
    public List<Libro> findByPianoScaffaleRipiano(Biblioteca biblioteca) throws ErrGestioneBiblioteca {
        return bibliotecaRepository.findAll().stream()
                .filter(b -> b.getPiano() == biblioteca.getPiano() &&
                        b.getScaffale() == biblioteca.getScaffale() &&
                        b.getRipiano() == biblioteca.getRipiano())
                .findAny()
                .map(Biblioteca::getLibri)
                .orElseThrow(ErrGestioneBiblioteca::new);
    }
}
