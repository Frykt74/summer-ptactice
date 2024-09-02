package org.example.fishingconfig47.services.impl;

import org.example.fishingconfig47.entities.Rod;
import org.example.fishingconfig47.exceptions.RodNotFoundException;
import org.example.fishingconfig47.repositories.RodRepository;
import org.example.fishingconfig47.services.RodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RodServiceImpl implements RodService {

    private final RodRepository rodRepository;

    @Autowired
    public RodServiceImpl(RodRepository rodRepository) {
        this.rodRepository = rodRepository;
    }

    public Rod getRodById(int id) {
        Rod findRod = rodRepository.findById(id);

        if (findRod == null) {
            throw new RodNotFoundException(id);
        }

        return findRod;
    }
}
