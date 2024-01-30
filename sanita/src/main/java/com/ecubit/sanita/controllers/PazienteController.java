package com.ecubit.sanita.controllers;

import com.ecubit.sanita.exceptions.ErrPersonaInesistente;
import com.ecubit.sanita.models.Medico;
import com.ecubit.sanita.models.Paziente;
import com.ecubit.sanita.services.PazienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RequestMapping("/sanita")
@RestController
public class PazienteController {

    private static Logger logger= LoggerFactory.getLogger(PazienteController.class);

    @Autowired
    private PazienteService pazienteService;

    @PostMapping("/paziente")
    public void addMedico(@RequestBody Paziente paziente,@RequestParam long id){
        try{
            pazienteService.aggiungiPaziente(paziente,id);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @GetMapping("/paziente/{id}")
    public Optional<Paziente> findMedicoById(@PathVariable long id) throws ErrPersonaInesistente {
        try{
            Optional<Paziente> p= pazienteService.getPazienteById(id);
            logger.info("Paziente trovato tramite id");
            return p;
        }catch (ErrPersonaInesistente e){
            throw e;
        }
    }

    @GetMapping("/paziente")
    public Paziente findPazienteByCodiceFiscale(@RequestParam String codiceFiscale) throws ErrPersonaInesistente {
        try{
            Paziente p=pazienteService.getPersonaByCodiceFiscale(codiceFiscale);
            logger.info("Paziente trovato tramite codiceFiscale");
            return p;
        }catch (ErrPersonaInesistente e){
            throw e;
        }
    }

    @GetMapping("/paziente/medico/{id}")
    public Medico findMedicoByPaziente(@PathVariable long id) throws ErrPersonaInesistente {
        try{
            Medico m= pazienteService.getMedicoByPersona(id);
            logger.info("Medico trovato");
            return m;
        }catch (ErrPersonaInesistente e){
            throw e;
        }
    }
}
