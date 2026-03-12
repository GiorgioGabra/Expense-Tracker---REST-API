package com.giorgio.expensetracker.controller;

import com.giorgio.expensetracker.entity.Cliente;
import com.giorgio.expensetracker.entity.Spesa;
import com.giorgio.expensetracker.repository.ClienteRepository;
import com.giorgio.expensetracker.repository.SpesaRepository;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/spese")
public class SpesaController {

    @Autowired
    private SpesaRepository spesaRepository;

    @Autowired
    private ClienteRepository clienteRepository; // Ci serve anche questo per cercare il cliente!

    // L'indirizzo sarà tipo: POST /api/spese/cliente/1
    @PostMapping("/cliente/{clienteId}")
    public Spesa aggiungiSpesa(@PathVariable Long clienteId, @RequestBody Spesa nuovaSpesa) {
        
        // 1. Cerchiamo il cliente nel database usando l'ID passato nell'indirizzo
        // (Se non lo trova, lancia un piccolo errore)
        Cliente clienteProprietario = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Errore: Cliente non trovato!"));

        // 2. "Attacchiamo" il cliente alla nuova spesa
        nuovaSpesa.setCliente(clienteProprietario);

        // 3. Salviamo la spesa nel database!
        return spesaRepository.save(nuovaSpesa);

        
    }
    // L'indirizzo sarà tipo: DELETE /api/spese/1 (dove 1 è l'ID della spesa sbagliata)
    @DeleteMapping("/{id}")
    public String eliminaSpesa(@PathVariable Long id) {
        
        // Diciamo a Spring di cancellare la spesa dal database usando il suo ID
        spesaRepository.deleteById(id);
        
        return "Spesa con ID " + id + " eliminata con successo. Il problema è risolto!";
    }

    // L'indirizzo sarà: GET /api/spese/totale/cliente/1
    @GetMapping("/totale/cliente/{clienteId}")
    public String getTotaleSpeseCliente(@PathVariable Long clienteId) {
        
        BigDecimal totale = spesaRepository.calcolaTotaleSpesePerCliente(clienteId);
        
        // Se il cliente non ha ancora spese, MySQL restituisce "null". Lo gestiamo così:
        if (totale == null) {
            return "Il cliente non ha ancora registrato nessuna spesa.";
        }
        
        return "Il totale speso dal cliente è: " + totale + " €";
    }

}