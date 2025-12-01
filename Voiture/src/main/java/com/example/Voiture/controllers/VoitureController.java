package com.example.Voiture.controllers;

import com.example.Voiture.entities.Voiture;
import com.example.Voiture.repositories.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VoitureController {
    @Autowired
    VoitureRepository voitureRepository;

    @GetMapping("/voitures")
    public List<Voiture> findAll() {
        return voitureRepository.findAll();
    }

    @GetMapping("/voiture/{id}")
    public Voiture findById(@PathVariable Long id) throws Exception {
        return voitureRepository.findById(id)
                .orElseThrow(() -> new Exception("Voiture non trouvée"));
    }
}
