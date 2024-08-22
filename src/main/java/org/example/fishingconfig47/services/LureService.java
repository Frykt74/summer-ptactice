package org.example.fishingconfig47.services;

import org.example.fishingconfig47.entities.Lure;
import org.example.fishingconfig47.repositories.impl.LureRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LureService {

    @Autowired
    private LureRepositoryImpl lureRepository;

    public Lure getLureById(Integer id) {
        return lureRepository.findById(id);
    }
}
