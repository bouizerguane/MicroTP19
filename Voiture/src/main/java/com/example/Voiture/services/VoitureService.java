package com.example.Voiture.services;

import com.example.Voiture.entities.Client;
import com.example.Voiture.entities.Voiture;
import com.example.Voiture.repositories.VoitureRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VoitureService {

    private final VoitureRepository voitureRepository;
    private final ClientService clientService;

    public VoitureService(VoitureRepository voitureRepository, ClientService clientService) {
        this.voitureRepository = voitureRepository;
        this.clientService = clientService;
    }

    public List<Voiture> findAllVoitures() {
        List<Voiture> voitures = voitureRepository.findAll();

        for (Voiture voiture : voitures) {
            Client client = clientService.clientById(voiture.getId_client());
            voiture.setClient(client);
        }

        return voitures;
    }

    public Voiture findVoitureById(Long id) {
        Voiture voiture = voitureRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Voiture non trouvée avec l'ID: " + id));

        Client client = clientService.clientById(voiture.getId_client());
        voiture.setClient(client);

        return voiture;
    }
}