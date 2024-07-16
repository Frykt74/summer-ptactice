package services;

import entities.Lure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.LureRepository;

@Service
public class LureService {

    @Autowired
    private LureRepository lureRepository;

    public Lure getLureById(int id) {
        return lureRepository.findLureById(id);
    }
}
