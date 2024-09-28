package com.exemplo.controller;

import com.exemplo.models.Funcionario;
import com.exemplo.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @GetMapping
    public List<Funcionario> getAll() {
        return funcionarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public Funcionario getById(@PathVariable Long id) {
        return funcionarioRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Funcionario create(@RequestBody Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    @PutMapping("/{id}")
    public Funcionario update(@PathVariable Long id, @RequestBody Funcionario funcionarioDetails) {
        Funcionario funcionario = funcionarioRepository.findById(id).orElse(null);
        if (funcionario != null) {
            funcionario.setNome(funcionarioDetails.getNome());
            funcionario.setCargo(funcionarioDetails.getCargo());
            return funcionarioRepository.save(funcionario);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        funcionarioRepository.deleteById(id);
    }
}
