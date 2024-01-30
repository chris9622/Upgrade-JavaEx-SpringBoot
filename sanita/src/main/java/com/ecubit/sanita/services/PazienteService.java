package com.ecubit.sanita.services;

import com.ecubit.sanita.exceptions.ErrPersonaInesistente;
import com.ecubit.sanita.models.Medico;
import com.ecubit.sanita.models.Paziente;

import java.util.ArrayList;
import java.util.Optional;

public interface PazienteService {

    void aggiungiPaziente(Paziente paziente,long id);

    Optional<Paziente> getPazienteById(long id) throws ErrPersonaInesistente;
    Paziente getPersonaByCodiceFiscale(String codiceFiscale) throws ErrPersonaInesistente;

    Medico getMedicoByPersona(long id) throws ErrPersonaInesistente;





}
