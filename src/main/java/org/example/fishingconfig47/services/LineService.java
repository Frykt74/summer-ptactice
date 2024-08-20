package org.example.fishingconfig47.services;

import org.example.fishingconfig47.entities.Line;
import org.example.fishingconfig47.repositories.RepositoryImpl.LineRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LineService {

    @Autowired
    private LineRepositoryImpl lineRepository;

    public Line getLineById(Integer id) {
        return lineRepository.findById(id);
    }
}
