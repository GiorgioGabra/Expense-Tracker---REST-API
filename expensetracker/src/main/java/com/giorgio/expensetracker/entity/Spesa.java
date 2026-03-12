package com.giorgio.expensetracker.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "spese")
public class Spesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descrizione;
    
    // Usiamo BigDecimal per i soldi (è molto più preciso dei numeri con la virgola normali)
    private BigDecimal importo; 
    
    private LocalDate data;

    // --- ECCO LA RELAZIONE! ---
    // Molte spese (@Many) appartengono a Un solo cliente (@ToOne)
    @ManyToOne
    @JoinColumn(name = "cliente_id") // Questo crea la "Chiave Esterna" (Foreign Key) su MySQL
    private Cliente cliente;

    // --- COSTRUTTORE VUOTO ---
    public Spesa() {
    }

    // --- GETTER E SETTER ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescrizione() { return descrizione; }
    public void setDescrizione(String descrizione) { this.descrizione = descrizione; }

    public BigDecimal getImporto() { return importo; }
    public void setImporto(BigDecimal importo) { this.importo = importo; }

    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
}