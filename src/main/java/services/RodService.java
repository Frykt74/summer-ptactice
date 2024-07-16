package services;

import entities.Rod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.RodRepository;

@Service
public class RodService {

    @Autowired
    private RodRepository rodRepository;

    public Rod getRodById(int id) {
        return rodRepository.findRodById(id);
    }
}
