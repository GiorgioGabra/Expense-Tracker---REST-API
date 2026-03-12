package com.giorgio.expensetracker.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "clienti")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cognome;
    private String pwd; 

    // Un cliente (@One) ha Molte spese (@ToMany)
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    @JsonIgnore // IMPORTANTISSIMO: Evita un errore di "loop infinito" quando stampiamo il JSON!
    private List<Spesa> spese;

    // Aggiungi anche i relativi Getter e Setter in fondo alla classe:
    public List<Spesa> getSpese() { return spese; }
    public void setSpese(List<Spesa> spese) { this.spese = spese; }

    // --- COSTRUTTORE VUOTO ---
    public Cliente() {
    }

    // --- GETTER E SETTER ---
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}