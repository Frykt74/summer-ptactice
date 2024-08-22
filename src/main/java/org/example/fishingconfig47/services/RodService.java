package org.example.fishingconfig47.services;

import org.example.fishingconfig47.entities.Rod;
import org.example.fishingconfig47.repositories.RodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RodService {

    private final RodRepository rodRepository;

    @Autowired
    public RodService(RodRepository rodRepository) {
        this.rodRepository = rodRepository;
    }

    public Rod getRodById(Integer id) {
        return rodRepository.findById(id);
    }
}
