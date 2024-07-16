package services;

import entities.Line;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.LineRepository;

@Service
public class LineService {

    @Autowired
    private LineRepository lineRepository;

    public Line getLineById(Integer id) {
        return lineRepository.findLineById(id);
    }
}
