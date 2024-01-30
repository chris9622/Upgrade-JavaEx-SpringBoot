package com.ecubit.sanita.repositories;

import com.ecubit.sanita.models.Medico;
import com.ecubit.sanita.models.Paziente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface MedicoRepository extends JpaRepository<Medico,Long> {

    Medico findByMatricola(String matricola);

}
