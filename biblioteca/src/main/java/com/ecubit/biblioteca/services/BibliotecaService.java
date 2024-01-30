package com.ecubit.biblioteca.services;

import com.ecubit.biblioteca.excepetions.ErrGestioneBiblioteca;
import com.ecubit.biblioteca.models.Biblioteca;
import com.ecubit.biblioteca.models.Libro;

import java.util.List;

public interface BibliotecaService {

    List<Biblioteca> addBiblioteca(Biblioteca biblioteca) throws ErrGestioneBiblioteca;

    List<Libro> findByPianoScaffaleRipiano(Biblioteca biblioteca) throws ErrGestioneBiblioteca;
}
