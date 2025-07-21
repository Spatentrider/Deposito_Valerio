package com.example.demo.controller;

import com.example.demo.model.Numero;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/listanumeri")
public class NumeriController {

    private List<Numero> numeri = new ArrayList<>();
    private Long idCounter = 1L;

    @GetMapping
    public List<Numero> getAll() {
        return numeri;
    }

    @PostMapping
    public ResponseEntity<Numero> crea(@RequestBody Numero nuovo) {
        nuovo.setId(idCounter++);
        numeri.add(nuovo);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuovo);
    }

        
    @GetMapping("/sommalista")
    public Double sommaNumeri() {
        return numeri.stream()
                 .mapToDouble(Numero::getNumero)
                 .sum();
}


    @GetMapping("/{id}")
    public ResponseEntity<Numero> getById(@PathVariable Long id) {
        return numeri.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    

    @PutMapping("/{id}")
    public ResponseEntity<Numero> aggiorna(@PathVariable Long id, @RequestBody Numero modificato) {
        for (Numero p : numeri) {
            if (p.getId().equals(id)) {
                p.setNumero(modificato.getNumero());
                return ResponseEntity.ok(p);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public String elimina(@PathVariable Long id) {
        numeri.removeIf(p -> p.getId().equals(id));
        return "Numero eliminato con successo.";
    }

}