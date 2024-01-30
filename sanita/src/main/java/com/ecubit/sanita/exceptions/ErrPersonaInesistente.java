package com.ecubit.sanita.exceptions;

@SuppressWarnings("serial")
public class ErrPersonaInesistente extends Exception {
    public ErrPersonaInesistente(){
        super("Persona inesistente");
    }
}
