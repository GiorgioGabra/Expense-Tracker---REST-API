package com.giorgio.expensetracker.controller;

import com.giorgio.expensetracker.entity.Cliente;
import com.giorgio.expensetracker.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clienti")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    // 1. Endpoint per SALVARE un nuovo cliente 
    @PostMapping("/registrazione")
    public Cliente registraCliente(@RequestBody Cliente nuovoCliente) {
        return repository.save(nuovoCliente); // Salva su MySQL e restituisce il cliente creato!
    }

    // 2. Endpoint bonus per VEDERE tutti i clienti
    @GetMapping("/tutti")
    public List<Cliente> mostraTutti() {
        return repository.findAll(); // Legge tutto da MySQL!
    }
}