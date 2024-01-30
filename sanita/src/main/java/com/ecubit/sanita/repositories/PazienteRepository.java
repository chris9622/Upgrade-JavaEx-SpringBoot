package com.ecubit.sanita.repositories;

import com.ecubit.sanita.models.Medico;
import com.ecubit.sanita.models.Paziente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository
public interface PazienteRepository extends JpaRepository<Paziente,Long> {
    Paziente findByCodiceFiscale(String codiceFiscale);



}
