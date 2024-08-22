package org.example.fishingconfig47.services;

import org.example.fishingconfig47.entities.Lure;
import org.example.fishingconfig47.repositories.LureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LureService {

    private final LureRepository lureRepository;

    @Autowired
    public LureService(LureRepository lureRepository) {
        this.lureRepository = lureRepository;
    }

    public Lure getLureById(Integer id) {
        return lureRepository.findById(id);
    }
}
