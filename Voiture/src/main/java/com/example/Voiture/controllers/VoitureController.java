package com.example.Voiture.controllers;

import com.example.Voiture.entities.Voiture;
import com.example.Voiture.repositories.VoitureRepository;
import com.example.Voiture.services.VoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VoitureController {

    private final VoitureService voitureService;

    public VoitureController(VoitureService voitureService) {
        this.voitureService = voitureService;
    }


    @GetMapping("/voitures")
    public List<Voiture> findAll() {
        return voitureService.findAllVoitures();
    }

    @GetMapping("/voiture/{id}")
    public Voiture findById(@PathVariable Long id) {
        return voitureService.findVoitureById(id);
    }
}
