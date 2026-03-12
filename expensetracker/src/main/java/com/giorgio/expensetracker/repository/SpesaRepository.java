package com.giorgio.expensetracker.repository;

import com.giorgio.expensetracker.entity.Spesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface SpesaRepository extends JpaRepository<Spesa, Long> {

    // Chiediamo a MySQL la somma (SUM) della colonna 'importo' per un cliente specifico
    @Query("SELECT SUM(s.importo) FROM Spesa s WHERE s.cliente.id = :clienteId")
    BigDecimal calcolaTotaleSpesePerCliente(@Param("clienteId") Long clienteId);

}