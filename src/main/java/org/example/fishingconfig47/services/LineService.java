package org.example.fishingconfig47.services;

import org.example.fishingconfig47.entities.Line;
import org.example.fishingconfig47.repositories.LineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LineService {

    private final LineRepository lineRepository;

    @Autowired
    public LineService(LineRepository lineRepository) {
        this.lineRepository = lineRepository;
    }

    public Line getLineById(Integer id) {
        return lineRepository.findById(id);
    }
}
