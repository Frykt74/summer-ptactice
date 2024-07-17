package org.example.fishingconfig47.services;

import org.example.fishingconfig47.entities.Lure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.fishingconfig47.repositories.LureRepository;

@Service
public class LureService {

    @Autowired
    private LureRepository lureRepository;

    public Lure getLureById(Integer id) {
        return lureRepository.findById(id).get();
    }
}
