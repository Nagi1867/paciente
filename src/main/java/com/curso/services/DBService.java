package com.curso.services;

import com.curso.domains.Paciente;
import com.curso.domains.enums.Status;
import com.curso.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

@Service
public class DBService {
    @Autowired
    private PacienteRepository pacienteRepo;


    public void initDB() {
        Paciente paciente1 = new Paciente (0, "Joao", Date.from(Instant.now()), new BigDecimal("2000"), Status.ATIVO);

        pacienteRepo.save(paciente1);
    }
}
