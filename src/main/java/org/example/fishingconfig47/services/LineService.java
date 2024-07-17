package org.example.fishingconfig47.services;

import org.example.fishingconfig47.entities.Line;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.fishingconfig47.repositories.LineRepository;

@Service
public class LineService {

    @Autowired
    private LineRepository lineRepository;

    public Line getLineById(Integer id) {
        return lineRepository.findById(id).get();
    }
}
