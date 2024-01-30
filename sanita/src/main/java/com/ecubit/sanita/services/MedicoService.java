package com.ecubit.sanita.services;

import com.ecubit.sanita.exceptions.ErrMedicoInesistente;
import com.ecubit.sanita.exceptions.ErrPersonaInesistente;
import com.ecubit.sanita.models.Medico;
import com.ecubit.sanita.models.Paziente;

import java.util.List;
import java.util.Optional;

public interface MedicoService {

    void aggiungiMedico(Medico medico);

    Optional<Medico> getMedicoById(long id) throws ErrMedicoInesistente;

    Medico getMedicoByMatricola(String matricola) throws ErrMedicoInesistente;

    List<Paziente> getPazientiByMedico(long id) throws ErrPersonaInesistente;


}
