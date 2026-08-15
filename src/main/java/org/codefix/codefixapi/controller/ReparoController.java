package org.codefix.codefixapi.controller;

import org.codefix.codefixapi.model.Reparo;
import org.codefix.codefixapi.repository.ReparoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reparos")
public class ReparoController {

    @Autowired
    private ReparoRepository repository;

    // 1. Listar todos
    @GetMapping
    public List<Reparo> listarTodos() {
        return repository.findAll();
    }

    // 2. Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Reparo> buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(reparo -> ResponseEntity.ok().body(reparo))
                .orElse(ResponseEntity.notFound().build());
    }

    // 3. Criar novo reparo
    @PostMapping
    public ResponseEntity<Reparo> criarReparo(@RequestBody Reparo reparo) {
        Reparo novoReparo = repository.save(reparo);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoReparo);
    }

    // 4. Atualizar reparo existente
    @PutMapping("/{id}")
    public ResponseEntity<Reparo> atualizarReparo(@PathVariable Long id, @RequestBody Reparo reparoAtualizado) {
        return repository.findById(id)
                .map(reparo -> {
                    reparo.setAparelho(reparoAtualizado.getAparelho());
                    reparo.setDefeito(reparoAtualizado.getDefeito());
                    reparo.setValor(reparoAtualizado.getValor());
                    reparo.setStatus(reparoAtualizado.getStatus());
                    Reparo atual = repository.save(reparo);
                    return ResponseEntity.ok().body(atual);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // 5. Deletar por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarReparo(@PathVariable Long id) {
        return repository.findById(id)
                .map(reparo -> {
                    repository.delete(reparo);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}