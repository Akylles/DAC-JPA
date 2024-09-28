package com.exemplo.controller;

import com.exemplo.models.Autor;
import com.exemplo.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @GetMapping
    public List<Autor> getAll() {
        return autorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Autor getById(@PathVariable Long id) {
        return autorRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Autor create(@RequestBody Autor autor) {
        return autorRepository.save(autor);
    }

    @PutMapping("/{id}")
    public Autor update(@PathVariable Long id, @RequestBody Autor autorDetails) {
        Autor autor = autorRepository.findById(id).orElse(null);
        if (autor != null) {
            autor.setNome(autorDetails.getNome());
            return autorRepository.save(autor);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        autorRepository.deleteById(id);
    }
}
