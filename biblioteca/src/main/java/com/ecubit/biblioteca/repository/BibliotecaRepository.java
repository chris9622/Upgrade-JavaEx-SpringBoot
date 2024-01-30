package com.ecubit.biblioteca.repository;

import com.ecubit.biblioteca.models.Biblioteca;
import com.ecubit.biblioteca.models.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BibliotecaRepository extends JpaRepository<Biblioteca,Long> {


}
