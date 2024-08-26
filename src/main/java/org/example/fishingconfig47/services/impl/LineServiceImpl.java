package org.example.fishingconfig47.services.impl;

import org.example.fishingconfig47.entities.Line;
import org.example.fishingconfig47.exceptions.LineNotFoundException;
import org.example.fishingconfig47.repositories.LineRepository;
import org.example.fishingconfig47.services.LineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LineServiceImpl implements LineService {

    private final LineRepository lineRepository;

    @Autowired
    public LineServiceImpl(LineRepository lineRepository) {
        this.lineRepository = lineRepository;
    }

    public Line getLineById(Integer id) {
        Line findLine = lineRepository.findById(id);
        if (findLine == null) {
            throw new LineNotFoundException("Line with id " + id + " not found");
        }
        return findLine;
    }
}
