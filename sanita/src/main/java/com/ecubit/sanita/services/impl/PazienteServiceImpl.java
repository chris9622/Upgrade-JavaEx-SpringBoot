package com.ecubit.sanita.services.impl;

import com.ecubit.sanita.exceptions.ErrMedicoInesistente;
import com.ecubit.sanita.exceptions.ErrPersonaInesistente;
import com.ecubit.sanita.models.Medico;
import com.ecubit.sanita.models.Paziente;
import com.ecubit.sanita.repositories.MedicoRepository;
import com.ecubit.sanita.repositories.PazienteRepository;
import com.ecubit.sanita.services.PazienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class PazienteServiceImpl implements PazienteService {

    private static Logger logger= LoggerFactory.getLogger(PazienteServiceImpl.class);

    @Autowired
    private PazienteRepository pazienteRepository;

    @Autowired
    private MedicoRepository medicoRepository;
    @Override
    public void aggiungiPaziente(Paziente paziente, long id) {
        try{
            Medico medico = medicoRepository.getReferenceById(id);
            Paziente p= new Paziente(paziente.getNome(),paziente.getCognome(),paziente.getCodiceFiscale());
            p.setMedico(medico);
            pazienteRepository.save(p);
            logger.info("Paziente Aggiunto");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Paziente> getPazienteById(long id) throws ErrPersonaInesistente {
        Optional<Paziente> p= pazienteRepository.findById(id);
        if(p.isPresent()){
            return p;
        }
        throw new ErrPersonaInesistente();
    }

    @Override
    public Paziente getPersonaByCodiceFiscale(String codiceFiscale) throws ErrPersonaInesistente {
        List<Paziente> pazienti= pazienteRepository.findAll();
        for(Paziente p:pazienti){
            if(p.getCodiceFiscale().equals(codiceFiscale)){
                return p;
            }
        }
        throw new ErrPersonaInesistente();
    }

    @Override
    public Medico getMedicoByPersona(long id) throws ErrPersonaInesistente {
        List<Paziente> pazienti= pazienteRepository.findAll();
        for(Paziente p:pazienti){
            if(p.getIdPaziente()==id){
                return p.getMedico();
            }
        }throw new ErrPersonaInesistente();
    }


}
