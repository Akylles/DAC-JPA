package com.exemplo.controller;

import com.exemplo.models.Reserva;
import com.exemplo.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaRepository reservaRepository;

    @GetMapping
    public List<Reserva> getAll() {
        return reservaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Reserva getById(@PathVariable Long id) {
        return reservaRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Reserva create(@RequestBody Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    @PutMapping("/{id}")
    public Reserva update(@PathVariable Long id, @RequestBody Reserva reservaDetails) {
        Reserva reserva = reservaRepository.findById(id).orElse(null);
        if (reserva != null) {
            reserva.setDataReserva(reservaDetails.getDataReserva());
            // Atualizar cliente e livro se necessário
            return reservaRepository.save(reserva);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        reservaRepository.deleteById(id);
    }
}
