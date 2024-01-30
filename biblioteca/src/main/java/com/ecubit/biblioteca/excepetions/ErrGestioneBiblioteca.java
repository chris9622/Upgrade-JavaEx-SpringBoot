package com.ecubit.biblioteca.excepetions;

public class ErrGestioneBiblioteca extends Exception{

    public ErrGestioneBiblioteca() {
        super("Non esiste questo dato selezionato");
    }
}
