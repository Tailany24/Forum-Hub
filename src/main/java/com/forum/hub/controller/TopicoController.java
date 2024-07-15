package com.forum.hub.controller;

import com.forum.hub.model.Topico;
import com.forum.hub.repository.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public ResponseEntity<Topico> criarTopico(@Valid @RequestBody Topico topico) {
        // Lógica para criar um novo tópico
        topico.setDataCriacao(LocalDateTime.now()); // Define a data de criação atual
        Topico novoTopico = topicoRepository.save(topico);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoTopico);
    }

    @GetMapping
    public ResponseEntity<List<Topico>> listarTodosOsTopicos() {
        List<Topico> topicos = topicoRepository.findAll();
        return ResponseEntity.ok(topicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topico> buscarTopicoPorId(@PathVariable Long id) {
        Optional<Topico> topico = topicoRepository.findById(id);
        if (topico.isPresent()) {
            return ResponseEntity.ok(topico.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topico> atualizarTopico(@PathVariable Long id, @Valid @RequestBody Topico topicoAtualizado) {
        Optional<Topico> optionalTopico = topicoRepository.findById(id);
        if (!optionalTopico.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Topico topicoExistente = optionalTopico.get();
        topicoExistente.setTitulo(topicoAtualizado.getTitulo());
        topicoExistente.setMensagem(topicoAtualizado.getMensagem());
        // Atualize outros campos conforme necessário

        Topico topicoAtualizadoEntity = topicoRepository.save(topicoExistente);
        return ResponseEntity.ok(topicoAtualizadoEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTopico(@PathVariable Long id) {
        Optional<Topico> topico = topicoRepository.findById(id);
        if (topico.isPresent()) {
            topicoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
