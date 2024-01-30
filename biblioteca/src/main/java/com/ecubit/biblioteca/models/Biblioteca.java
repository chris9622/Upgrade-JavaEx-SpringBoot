package com.ecubit.biblioteca.models;

import com.ecubit.biblioteca.excepetions.ErrGestioneBiblioteca;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "biblioteca")
public class Biblioteca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_biblioteca")
    private long idBiblioteca;

    private int piano;

    private int scaffale;

    private int ripiano;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "biblioteca", cascade = CascadeType.ALL)
    private List<Libro> libri;

    public Biblioteca( int piano, int scaffale, int ripiano) throws ErrGestioneBiblioteca {
        if(piano >= 1 && piano <= 3) {
            this.piano = piano;
            if (scaffale >= 1 && scaffale <= 30) {
                this.scaffale = scaffale;
                if (ripiano >= 1 && ripiano <= 6) {
                    this.ripiano = ripiano;
                }
            }
        }else{
            throw new ErrGestioneBiblioteca();
        }
    }

    public Biblioteca(int piano, int scaffale, int ripiano, List<Libro> libri) throws ErrGestioneBiblioteca {
        if(piano >= 1 && piano <= 3){
            this.piano = piano;
            if(scaffale >= 1 && scaffale <= 30){
                this.scaffale = scaffale;
                if(ripiano >= 1 && ripiano <= 6){
                    this.ripiano = ripiano;
                    if(libri.size()<=10){
                        this.libri = libri;
                    }
                }
            }
        }else{
            throw new ErrGestioneBiblioteca();
        }

    }


}
