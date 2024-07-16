package services;

import entities.Reel;
import entities.Rod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.RodReelRepository;

@Service
public class RodReelService {

    @Autowired
    private RodReelRepository rodReelRepository;

    public boolean existsRodAndReel(Rod rod, Reel reel) {
        return rodReelRepository.findByRodAndReel(rod, reel);
    }
}
