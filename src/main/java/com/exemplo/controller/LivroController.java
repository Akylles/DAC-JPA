package com.exemplo.controller;

import com.exemplo.models.Livro;
import com.exemplo.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping
    public List<Livro> getAll() {
        return livroRepository.findAll();
    }

    @GetMapping("/{id}")
    public Livro getById(@PathVariable Long id) {
        return livroRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Livro create(@RequestBody Livro livro) {
        return livroRepository.save(livro);
    }

    @PutMapping("/{id}")
    public Livro update(@PathVariable Long id, @RequestBody Livro livroDetails) {
        Livro livro = livroRepository.findById(id).orElse(null);
        if (livro != null) {
            livro.setTitulo(livroDetails.getTitulo());
            livro.setIsbn(livroDetails.getIsbn());
            // Atualizar autor e categoria se necessário
            return livroRepository.save(livro);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        livroRepository.deleteById(id);
    }
}
