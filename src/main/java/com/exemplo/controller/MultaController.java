package com.exemplo.controller;

import com.exemplo.models.Multa;
import com.exemplo.repositories.MultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/multas")
public class MultaController {

    @Autowired
    private MultaRepository multaRepository;

    @GetMapping
    public List<Multa> getAll() {
        return multaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Multa getById(@PathVariable Long id) {
        return multaRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Multa create(@RequestBody Multa multa) {
        return multaRepository.save(multa);
    }

    @PutMapping("/{id}")
    public Multa update(@PathVariable Long id, @RequestBody Multa multaDetails) {
        Multa multa = multaRepository.findById(id).orElse(null);
        if (multa != null) {
            multa.setValor(multaDetails.getValor());
            return multaRepository.save(multa);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        multaRepository.deleteById(id);
    }
}
