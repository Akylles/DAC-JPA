package com.exemplo.controller;

import com.exemplo.models.Editora;
import com.exemplo.repositories.EditoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/editoras")
public class EditoraController {

    @Autowired
    private EditoraRepository editoraRepository;

    @GetMapping
    public List<Editora> getAll() {
        return editoraRepository.findAll();
    }

    @GetMapping("/{id}")
    public Editora getById(@PathVariable Long id) {
        return editoraRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Editora create(@RequestBody Editora editora) {
        return editoraRepository.save(editora);
    }

    @PutMapping("/{id}")
    public Editora update(@PathVariable Long id, @RequestBody Editora editoraDetails) {
        Editora editora = editoraRepository.findById(id).orElse(null);
        if (editora != null) {
            editora.setNome(editoraDetails.getNome());
            return editoraRepository.save(editora);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        editoraRepository.deleteById(id);
    }
}
