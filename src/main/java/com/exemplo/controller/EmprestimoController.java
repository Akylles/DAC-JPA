package com.exemplo.controller;

import com.exemplo.models.Emprestimo;
import com.exemplo.repositories.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @GetMapping
    public List<Emprestimo> getAll() {
        return emprestimoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Emprestimo getById(@PathVariable Long id) {
        return emprestimoRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Emprestimo create(@RequestBody Emprestimo emprestimo) {
        return emprestimoRepository.save(emprestimo);
    }

    @PutMapping("/{id}")
    public Emprestimo update(@PathVariable Long id, @RequestBody Emprestimo emprestimoDetails) {
        Emprestimo emprestimo = emprestimoRepository.findById(id).orElse(null);
        if (emprestimo != null) {
            emprestimo.setDataEmprestimo(emprestimoDetails.getDataEmprestimo());
            emprestimo.setDataDevolucao(emprestimoDetails.getDataDevolucao());
            // Atualizar cliente e livro se necessário
            return emprestimoRepository.save(emprestimo);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        emprestimoRepository.deleteById(id);
    }
}
