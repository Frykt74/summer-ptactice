package org.example.fishingconfig47.services;

import org.example.fishingconfig47.entities.Rod;
import org.example.fishingconfig47.repositories.impl.RodRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RodService {

    @Autowired
    private RodRepositoryImpl rodRepository;

    public Rod getRodById(Integer id) {
        return rodRepository.findById(id);
    }
}
