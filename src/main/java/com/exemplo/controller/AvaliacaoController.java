package com.exemplo.controller;

import com.exemplo.models.Avaliacao;
import com.exemplo.repositories.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @GetMapping
    public List<Avaliacao> getAll() {
        return avaliacaoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Avaliacao getById(@PathVariable Long id) {
        return avaliacaoRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Avaliacao create(@RequestBody Avaliacao avaliacao) {
        return avaliacaoRepository.save(avaliacao);
    }

    @PutMapping("/{id}")
    public Avaliacao update(@PathVariable Long id, @RequestBody Avaliacao avaliacaoDetails) {
        Avaliacao avaliacao = avaliacaoRepository.findById(id).orElse(null);
        if (avaliacao != null) {
            avaliacao.setNota(avaliacaoDetails.getNota());
            avaliacao.setComentario(avaliacaoDetails.getComentario());
            return avaliacaoRepository.save(avaliacao);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        avaliacaoRepository.deleteById(id);
    }
}

