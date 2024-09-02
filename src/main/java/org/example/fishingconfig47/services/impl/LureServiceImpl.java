package org.example.fishingconfig47.services.impl;

import org.example.fishingconfig47.entities.Lure;
import org.example.fishingconfig47.exceptions.LureNotFoundException;
import org.example.fishingconfig47.repositories.LureRepository;
import org.example.fishingconfig47.services.LureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LureServiceImpl implements LureService {

    private final LureRepository lureRepository;

    @Autowired
    public LureServiceImpl(LureRepository lureRepository) {
        this.lureRepository = lureRepository;
    }

    public Lure getLureById(int id) {
        Lure findLure = lureRepository.findById(id);

        if (findLure == null) {
            throw new LureNotFoundException(id);
        }

        return findLure;
    }
}
