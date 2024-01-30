package com.ecubit.biblioteca.services;

import com.ecubit.biblioteca.excepetions.ErrGestioneBiblioteca;
import com.ecubit.biblioteca.models.Biblioteca;
import com.ecubit.biblioteca.models.Libro;

import java.util.List;

public interface LibroService {

    List<Libro> addLibro(Libro libro) throws ErrGestioneBiblioteca;

    Biblioteca getBibliotecaByLibro(Libro libro) throws ErrGestioneBiblioteca;
}
