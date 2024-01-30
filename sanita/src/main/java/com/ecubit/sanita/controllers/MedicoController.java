package com.ecubit.sanita.controllers;

import com.ecubit.sanita.exceptions.ErrMedicoInesistente;
import com.ecubit.sanita.exceptions.ErrPersonaInesistente;
import com.ecubit.sanita.models.Medico;
import com.ecubit.sanita.models.Paziente;
import com.ecubit.sanita.services.MedicoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RequestMapping("/sanita")
@RestController
public class MedicoController {

    private static Logger logger= LoggerFactory.getLogger(MedicoController.class);


    @Autowired
    private MedicoService medicoService;

    @PostMapping("/medico")
    public void addMedico(@RequestBody Medico medico){
        try{
            medicoService.aggiungiMedico(medico);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @GetMapping("/medico/{id}")
    public Optional<Medico> findMedicoById(@PathVariable long id) throws ErrMedicoInesistente {
        try {
            Optional<Medico> medico = medicoService.getMedicoById(id);
            logger.info("Medico trovato tramite id");
            return medico;
        }catch(ErrMedicoInesistente e){
            throw e;
        }
    }

    @GetMapping("/medico")
    public Medico findMedicoByMatricola(@RequestParam String matricola) throws ErrMedicoInesistente {
        try{
            Medico medico= medicoService.getMedicoByMatricola(matricola);
            logger.info("Medico trovato tramite matricola");
            return medico;
        }catch (ErrMedicoInesistente e){
            throw e;
        }

    }

    @GetMapping("/medico/pazienti/{id}")
    public List<Paziente> findPazientiByMedico(@PathVariable long id) throws ErrPersonaInesistente {
        try{
            List<Paziente> pazienti= medicoService.getPazientiByMedico(id);
            logger.info("Pazienti trovati tramite Medico");
            return pazienti;
        }catch (ErrPersonaInesistente e){
            throw e;
        }
    }



}
