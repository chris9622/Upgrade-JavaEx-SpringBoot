package com.ecubit.sanita.services.impl;

import com.ecubit.sanita.exceptions.ErrMedicoInesistente;
import com.ecubit.sanita.exceptions.ErrPersonaInesistente;
import com.ecubit.sanita.models.Medico;
import com.ecubit.sanita.models.Paziente;
import com.ecubit.sanita.repositories.MedicoRepository;
import com.ecubit.sanita.services.MedicoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MedicoServiceImpl implements MedicoService {

    private static Logger logger = LoggerFactory.getLogger(MedicoServiceImpl.class);

    @Autowired
    private MedicoRepository medicoRepository;
    @Override
    public void aggiungiMedico(Medico medico) {
       try{
            Medico medicoN=new Medico(medico.getNome(),medico.getCognome(), medico.getCodiceFiscale(), medico.getMatricola());
            List<Paziente> pazienti=new ArrayList<>();
            for(Paziente p:medico.getPazienti()){
                Paziente paziente= new Paziente(p.getNome(),p.getCognome(),p.getCodiceFiscale());
                paziente.setMedico(medicoN);
                pazienti.add(paziente);
            }
            medicoN.setPazienti(pazienti);
            medicoRepository.save(medicoN);
            logger.info("Medico Aggiunto");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Medico> getMedicoById(long id) throws ErrMedicoInesistente {
       Optional<Medico> m= medicoRepository.findById(id);
       if(!m.isEmpty()){
           return m;
       }
       throw new ErrMedicoInesistente();
    }

    @Override
    public Medico getMedicoByMatricola(String matricola) throws ErrMedicoInesistente {
        List<Medico> medici= medicoRepository.findAll();
        for(Medico m:medici){
            if(m.getMatricola().equals(matricola)){
                return m;
            }
        } throw new ErrMedicoInesistente();
    }

    @Override
    public List<Paziente> getPazientiByMedico(long id) throws ErrPersonaInesistente {
        List<Medico> medici= medicoRepository.findAll();
        for(Medico m:medici){
            if(m.getIdMedico()==id){
                return m.getPazienti();
            }
        }


        throw new ErrPersonaInesistente();
    }
}


/*
 for(Medico m:medici){
            if(m.getIdMedico()==id){
                return m.getPazienti();
            }
        }
 */